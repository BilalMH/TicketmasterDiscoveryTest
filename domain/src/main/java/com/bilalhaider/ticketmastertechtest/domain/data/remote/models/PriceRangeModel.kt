package com.bilalhaider.ticketmastertechtest.domain.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class PriceRangeModel(
    val type: String,
    val currency: String,
    val min: Double,
    val max: Double
)
