package com.bilalhaider.ticketmastertechtest.data.remote.apis

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

abstract class KtorApi {

    companion object {
        const val BASE_URL = "https://app.ticketmaster.com"
        const val APP_API_KEY = "DW0E98NrxUIfDDtNN7ijruVSm60ryFLX"
    }

    private var _httpClient: HttpClient? = client()

    fun client(): HttpClient {
        return _httpClient ?: synchronized(this) {
            val newInstance = HttpClient(Android) {
                expectSuccess = true

                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
//                            Log.d("HttpClient", message)
                        }
                    }

                    level = LogLevel.ALL
                }

                // Installing ContentNegotiation is how we handle JSON serialization in Ktor
                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            prettyPrint = true
                            isLenient = true
                        }
                    )
                }
            }
            _httpClient = newInstance
            newInstance
        }
    }

    fun close() {
//        Log.d("HttpClient", "closing the client...")
        _httpClient?.close()
        _httpClient = null
    }

}