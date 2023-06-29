package com.bilalhaider.ticketmastertechtest.domain.data.local.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.AgeRestrictionModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.ClassificationModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DateModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.EmbeddedModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.EventModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.ImageModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.LinkModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.PriceRangeModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.SaleModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.TicketLimitModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

@ProvidedTypeConverter
class EventTypeConverters @Inject constructor() {

    @TypeConverter
    fun fromEvent(events: EventModel): String {
        return Json.encodeToString(events)
    }

    @TypeConverter
    fun toEvent(json: String): EventModel {
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromImageModel(images: List<ImageModel>): String {
        return Json.encodeToString(images)
    }

    @TypeConverter
    fun toImageModel(json: String): List<ImageModel> {
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromSaleModel(saleModel: SaleModel): String {
        return Json.encodeToString(saleModel)
    }

    @TypeConverter
    fun toSaleModel(json: String): SaleModel {
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromDateModel(dateModel: DateModel): String {
        return Json.encodeToString(dateModel)
    }

    @TypeConverter
    fun toDateModel(json: String): DateModel {
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromClassificationModel(classificationsModels: List<ClassificationModel>): String {
        return Json.encodeToString(classificationsModels)
    }

    @TypeConverter
    fun toClassificationModel(json: String): List<ClassificationModel> {
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromPriceRangeModel(priceRangeModels: List<PriceRangeModel>): String {
        return Json.encodeToString(priceRangeModels)
    }

    @TypeConverter
    fun toPriceRangeModel(json: String): List<PriceRangeModel> {
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromTicketLimitModel(ticketLimitModel: TicketLimitModel): String {
        return Json.encodeToString(ticketLimitModel)
    }

    @TypeConverter
    fun toTicketLimitModel(json: String): TicketLimitModel {
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromAgeRestrictionModel(ageRestrictionModel: AgeRestrictionModel): String {
        return Json.encodeToString(ageRestrictionModel)
    }

    @TypeConverter
    fun toAgeRestrictionModel(json: String): AgeRestrictionModel {
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromLinkModel(linkModel: LinkModel): String {
        return Json.encodeToString(linkModel)
    }

    @TypeConverter
    fun toLinkModel(json: String): LinkModel {
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromEmbeddedModel(embeddedModel: EmbeddedModel): String {
        return Json.encodeToString(embeddedModel)
    }

    @TypeConverter
    fun toEmbeddedModel(json: String): EmbeddedModel {
        return Json.decodeFromString(json)
    }

}