package com.bilalhaider.ticketmastertechtest.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class AgeRestrictionModel(
    val legalAgeEnforced: Boolean
)
