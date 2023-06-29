package com.bilalhaider.ticketmastertechtest.domain.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bilalhaider.ticketmastertechtest.domain.data.local.db.dao.DiscoveryEventDao
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoveryEventModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.EventModel

@Database(entities = [EventModel::class], version = 1, exportSchema = false)
@TypeConverters(EventTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun eventDao(): DiscoveryEventDao
}