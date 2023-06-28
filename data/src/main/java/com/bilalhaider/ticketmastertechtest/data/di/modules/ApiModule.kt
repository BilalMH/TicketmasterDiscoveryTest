package com.bilalhaider.ticketmastertechtest.data.di.modules

import com.bilalhaider.ticketmastertechtest.data.remote.apis.DiscoveryApiServiceImpl
import com.bilalhaider.ticketmastertechtest.data.remote.interfaces.DiscoveryApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface ApiModule {

//    @Provides
//    fun provideDiscoveryService(discoveryApiServiceImpl: DiscoveryApiServiceImpl): DiscoveryApiService

}