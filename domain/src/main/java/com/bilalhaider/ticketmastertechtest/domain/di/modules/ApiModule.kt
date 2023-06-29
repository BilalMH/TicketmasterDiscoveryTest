package com.bilalhaider.ticketmastertechtest.domain.di.modules

import com.bilalhaider.ticketmastertechtest.domain.data.remote.apis.DiscoveryApiServiceImpl
import com.bilalhaider.ticketmastertechtest.domain.data.remote.interfaces.DiscoveryApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface ApiModule {

    @Binds
    fun bindDiscoveryService(discoveryApiServiceImpl: DiscoveryApiServiceImpl): DiscoveryApiService

}