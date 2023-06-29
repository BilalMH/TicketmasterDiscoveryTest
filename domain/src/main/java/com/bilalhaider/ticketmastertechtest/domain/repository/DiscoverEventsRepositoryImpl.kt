package com.bilalhaider.ticketmastertechtest.domain.repository

import com.bilalhaider.ticketmastertechtest.domain.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.domain.data.local.db.AppDatabase
import com.bilalhaider.ticketmastertechtest.domain.data.remote.apis.DiscoveryApiServiceImpl
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoverEventsResponse
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoveryEventModel
import com.bilalhaider.ticketmastertechtest.domain.repository.interfaces.DiscoverEventsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class DiscoverEventsRepositoryImpl @Inject constructor(
    private val discoveryApiService: DiscoveryApiServiceImpl
) : DiscoverEventsRepository {

    private val _eventData = MutableStateFlow<DiscoveryEventModel?>(null)
    override val eventData: StateFlow<DiscoveryEventModel?> = _eventData.asStateFlow()

    override fun close() {
        discoveryApiService.close()
    }

    override suspend fun searchEvents(eventName: String) {
        discoveryApiService.discoverEventBySearch(eventName).run {
            if (this is ServiceResult.Success<DiscoverEventsResponse>) {
                _eventData.value = data.discoveryEvent
            }
        }
    }
}