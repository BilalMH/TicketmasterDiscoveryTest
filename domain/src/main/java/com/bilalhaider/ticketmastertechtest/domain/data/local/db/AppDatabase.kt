package com.bilalhaider.ticketmastertechtest.domain.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bilalhaider.ticketmastertechtest.domain.data.local.db.dao.LocalDiscoveryEvent
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoveryEventModel

@Database(entities = arrayOf(DiscoveryEventModel::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun eventDao(): LocalDiscoveryEvent
}

private lateinit var INSTANCE: AppDatabase

fun getDatabase(context: Context): AppDatabase {
    synchronized(AppDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "eventsDatabase"
            ).build()
        }
    }

    return INSTANCE
}