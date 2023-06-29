package com.bilalhaider.ticketmastertechtest.domain.data

sealed class ServiceResult<out T> {
    data class Success<out T>(val data: T) : ServiceResult<T>()
    data class Error(val code: String, val message: String) : ServiceResult<Nothing>()
}

val ServiceResult<*>.succeeded
    get() = this is ServiceResult.Success

val ServiceResult<*>.error
    get() = this is ServiceResult.Error