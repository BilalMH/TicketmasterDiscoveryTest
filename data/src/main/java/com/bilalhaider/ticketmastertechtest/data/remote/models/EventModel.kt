package com.bilalhaider.ticketmastertechtest.data.remote.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//Using SerialName annotations "_links" and "_embedded" to allow for better readability in the code instead of following API response

@Serializable
@Entity("discoveryEvents")
data class DiscoveryEventModel(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val events: List<EventModel>
)

@Serializable
data class EventModel(
    val name: String,
    val type: String,
    val id: String,
    val test: Boolean,
    val url: String,
    val locale: String,
    val images: List<ImageModel>,
    val sales: SaleModel,
    val dates: DateModel,
    val classifications: List<ClassificationModel>,
    val info: String,
    val pleaseNote: String,
    val priceRanges: List<PriceRangeModel>,
    val ticketLimit: TicketLimitModel? = null,
    val ageRestrictions: AgeRestrictionModel,
    @SerialName("_links") val links: LinkModel,
    @SerialName("_embedded") val venuesAndAttractions: EmbeddedModel
)
