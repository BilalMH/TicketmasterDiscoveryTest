package com.bilalhaider.ticketmastertechtest.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class EmbeddedModel(
    val venues: List<VenueModel>
)

@Serializable
data class VenueModel(
    val name: String,
    val type: String,
    val id: String,
    val postalCode: String,
    val city: CityModel,
    val country: CountryModel,
    val address: AddressModel
)

@Serializable
data class CityModel(
    val name: String
)

@Serializable
data class CountryModel(
    val name: String,
    val countryCode: String
)

@Serializable
data class AddressModel(
    val line1: String
)


