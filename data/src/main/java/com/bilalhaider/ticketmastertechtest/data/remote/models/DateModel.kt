package com.bilalhaider.ticketmastertechtest.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class DateModel(
    val start: StartModel,
    val timezone: String,
    val status: StatusModel,
    val spanMultipleDays: Boolean
)

@Serializable
data class StartModel(
    val localDate: String,
    val localTime: String? = null,
    val dateTime: String? = null,
    val dateTBD: Boolean,
    val dateTBA: Boolean,
    val timeTBA: Boolean,
    val noSpecificTime: Boolean
)

@Serializable
data class StatusModel(
    val code: String
)
