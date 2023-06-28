package com.bilalhaider.ticketmastertechtest.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bilalhaider.ticketmastertechtest.data.remote.models.DiscoveryEventModel
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalDiscoveryEvent {

    @Query("SELECT * FROM discoveryEvents")
    fun getEvents() : Flow<List<DiscoveryEventModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(events: DiscoveryEventModel)

    @Delete
    fun delete(event: DiscoveryEventModel)

}