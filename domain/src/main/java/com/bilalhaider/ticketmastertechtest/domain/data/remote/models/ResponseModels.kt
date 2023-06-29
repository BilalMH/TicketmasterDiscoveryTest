package com.bilalhaider.ticketmastertechtest.domain.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class DiscoverEventsResponse(
    @SerialName("_embedded") val discoveryEvent: DiscoveryEventModel
)