package com.bilalhaider.ticketmastertechtest.util

/**
 * Types of errors that routes could produce. These
 * codes are returned in the response body.
 */
enum class ErrorCode(val message: String) {
    API_KEY("There was a problem generating your API Key. Try again."),
    UNKNOWN("An unknown error has occurred."),
    DATABASE_ERROR("Unknown database error. Try again, and check your parameters."),
    INVALID_JSON("Your JSON must match the format in this sample response."),
    INVALID_API_KEY("Bad API key."),
    SERVER_ERROR("Unknown API server error."),
    JOB_CANCELLED("Coroutine cancelled.")
}

class AuthenticationException : RuntimeException()