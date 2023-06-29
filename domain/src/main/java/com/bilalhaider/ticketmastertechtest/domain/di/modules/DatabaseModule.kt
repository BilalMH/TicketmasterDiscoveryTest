package com.bilalhaider.ticketmastertechtest.domain.di.modules

import android.content.Context
import androidx.room.Room
import com.bilalhaider.ticketmastertechtest.domain.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideAppDatabase(
        @ApplicationContext application: Context
    ): AppDatabase = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "EventsDatabase"
    ).build()
}