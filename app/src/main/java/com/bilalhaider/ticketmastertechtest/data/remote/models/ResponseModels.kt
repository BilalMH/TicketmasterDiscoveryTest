package com.bilalhaider.ticketmastertechtest.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class DiscoverEventsResponse(
    @SerialName("_embedded") val discoverEvent: DiscoverEventModel,
    val errors: List<ResponseErrors> = emptyList()
)

@Serializable
data class ResponseErrors(val code: String, val message: String)