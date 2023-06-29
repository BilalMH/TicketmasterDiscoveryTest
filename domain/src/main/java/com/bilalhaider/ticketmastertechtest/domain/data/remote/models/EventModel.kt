package com.bilalhaider.ticketmastertechtest.domain.data.remote.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//Using SerialName annotations "_links" and "_embedded" to allow for better readability in the code instead of following API response

@Serializable
data class DiscoveryEventModel(
    val events: List<EventModel>
)

@Serializable
@Entity("discoveryEvents")
data class EventModel(
    @PrimaryKey val id: String,
    val name: String,
    val type: String? = null,
    val test: Boolean? = null,
    val url: String? = null,
    val locale: String? = null,
    val images: List<ImageModel>,
    val sales: SaleModel? = null,
    val dates: DateModel,
    val classifications: List<ClassificationModel>? = emptyList(),
    val info: String? = null,
    val pleaseNote: String? = null,
    val priceRanges: List<PriceRangeModel>? = emptyList(),
    val ticketLimit: TicketLimitModel? = null,
    val ageRestrictions: AgeRestrictionModel? = null,
    @SerialName("_links") val links: LinkModel? = null,
    @SerialName("_embedded") val venuesAndAttractions: EmbeddedModel
)
