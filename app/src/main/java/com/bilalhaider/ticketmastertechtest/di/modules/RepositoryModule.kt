package com.bilalhaider.ticketmastertechtest.di.modules

import com.bilalhaider.ticketmastertechtest.domain.repository.DiscoverEventsRepositoryImpl
import com.bilalhaider.ticketmastertechtest.domain.repository.interfaces.DiscoverEventsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    fun bindDiscoverEventsRepository(discoverEventsRepositoryImpl: DiscoverEventsRepositoryImpl): DiscoverEventsRepository

}