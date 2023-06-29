package com.bilalhaider.ticketmastertechtest.domain.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class ImageModel(
    val ratio: String? = null,
    val url: String? = null,
    val width: Long? = null,
    val height: Long? = null,
    val fallback: Boolean? = null
)
