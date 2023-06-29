package com.bilalhaider.ticketmastertechtest.domain.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class SaleModel(
    val public: PublicSalesModel
)

@Serializable
data class PublicSalesModel(
    val startDateTime: String,
    val startTBD: Boolean,
    val startTBA: Boolean,
    val endDateTime: String
)
