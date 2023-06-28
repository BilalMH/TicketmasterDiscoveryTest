package com.bilalhaider.ticketmastertechtest.util

import android.util.Log
import com.bilalhaider.ticketmastertechtest.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.data.remote.models.DiscoverEventsResponse
import com.bilalhaider.ticketmastertechtest.data.remote.models.ResponseErrors
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.serialization.json.Json
import java.util.concurrent.CancellationException

inline fun <reified T> String.toErrorResponse(): T {
    val errorResponse = this.substringAfter("Text: \"").dropLast(1)
    Log.d("debug", "errorResponse parsed: $errorResponse")
    return Json.decodeFromString(errorResponse)
}

inline fun <reified  T> Exception.toApiError(): ServiceResult.Error {

    val code = "API_ERROR"
    val message = message ?: "Network Error"

    return try {
        when(this) {
            is CancellationException -> ServiceResult.Error(
                ErrorCode.JOB_CANCELLED.name,
                ErrorCode.JOB_CANCELLED.message
            )
            is ServerResponseException,
            is ClientRequestException -> {
                val errors = when (val discoveryApiResponse: T = message.toErrorResponse()) {
                    is DiscoverEventsResponse -> discoveryApiResponse.errors.firstOrNull() ?: ResponseErrors(code, message)
                    else -> ResponseErrors(code, message)
                }
                ServiceResult.Error(errors.code, errors.message)
            }
            else -> {
                ServiceResult.Error(code, message)
            }
        }
    } catch (parseError: Exception) {
        ServiceResult.Error(code, message)
    }
}