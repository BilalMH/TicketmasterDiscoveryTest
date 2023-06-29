package com.bilalhaider.ticketmastertechtest.domain.data.local.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.EventModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@ProvidedTypeConverter
class EventTypeConverters {

    @TypeConverter
    fun fromEvent(events: List<EventModel>): String {
        return Json.encodeToString(events)
    }

    @TypeConverter
    fun toEvent(json: String): List<EventModel> {
        return Json.decodeFromString(json)
    }

}