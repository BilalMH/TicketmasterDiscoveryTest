package com.bilalhaider.ticketmastertechtest.data.remote.api.creators

import com.bilalhaider.ticketmastertechtest.data.remote.apis.ApiRoutes
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private val responseHeaders = headersOf(HttpHeaders.ContentType, "application/json")

// Mocking a success client for happy paths, with Ktor we can feed MockEngine into our HttpClient to create a MockClient
val ktorSuccessClient = HttpClient(MockEngine) {
    engine {
        addHandler { request ->
            when (request.url.encodedPath) {
                ApiRoutes.DISCOVERY -> respond(
                    discoverEventSuccessJSON,
                    HttpStatusCode.OK,
                    responseHeaders
                )

                else -> error("Unhandled ${request.url.encodedPath}")
            }
        }
    }

    expectSuccess = true

    install(ContentNegotiation) {
        json(
            Json{
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            }
        )
    }
}