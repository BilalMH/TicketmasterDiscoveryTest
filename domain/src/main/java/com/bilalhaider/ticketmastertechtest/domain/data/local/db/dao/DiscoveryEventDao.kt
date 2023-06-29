package com.bilalhaider.ticketmastertechtest.domain.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoveryEventModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.EventModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DiscoveryEventDao {

    @Query("SELECT * FROM discoveryEvents")
    fun getEvents() : Flow<List<EventModel>>

    @Query("SELECT * FROM discoveryEvents where id = :eventId")
    fun getOneEvent(eventId: String) : EventModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(events: EventModel)

    @Delete
    fun delete(event: EventModel)

}