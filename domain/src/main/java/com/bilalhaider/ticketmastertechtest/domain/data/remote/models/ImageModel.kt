package com.bilalhaider.ticketmastertechtest.domain.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class ImageModel(
    val ratio: String,
    val url: String,
    val width: Long,
    val height: Long,
    val fallback: Boolean
)
