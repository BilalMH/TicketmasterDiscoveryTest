package com.bilalhaider.ticketmastertechtest.data.remote.api.creators

import com.bilalhaider.ticketmastertechtest.domain.data.remote.apis.ApiRoutes
import com.bilalhaider.ticketmastertechtest.domain.data.remote.apis.KtorApi
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf

private val responseHeaders = headersOf(HttpHeaders.ContentType, "application/json")

val mockEngine = MockEngine {request ->
        when (request.url.encodedPath) {
            ApiRoutes.DISCOVERY -> respond(
                discoverEventSuccessJSON,
                HttpStatusCode.OK,
                responseHeaders
            )

            else -> error("Unhandled ${request.url.encodedPath}")
        }
    }

// Mocking a success client for happy paths, with Ktor we can feed MockEngine into our HttpClient to create a MockClient
val ktorSuccessClient = KtorApi(mockEngine).client()