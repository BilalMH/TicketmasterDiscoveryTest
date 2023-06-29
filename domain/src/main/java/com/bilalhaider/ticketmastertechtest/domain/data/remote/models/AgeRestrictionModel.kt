package com.bilalhaider.ticketmastertechtest.domain.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class AgeRestrictionModel(
    val legalAgeEnforced: Boolean
)
