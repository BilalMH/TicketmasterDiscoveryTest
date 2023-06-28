package com.bilalhaider.ticketmastertechtest.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class ClassificationModel(
    val primary: Boolean,
    val segment: GenericSegmentModel,
    val genre: GenericSegmentModel,
    val subGenre: GenericSegmentModel,
    val type: GenericSegmentModel,
    val subType: GenericSegmentModel,
    val family: Boolean
)

@Serializable
data class GenericSegmentModel(
    val id: String,
    val name: String
)