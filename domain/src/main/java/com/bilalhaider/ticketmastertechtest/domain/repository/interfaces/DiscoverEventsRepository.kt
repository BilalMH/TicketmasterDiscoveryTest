package com.bilalhaider.ticketmastertechtest.domain.repository.interfaces

import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoveryEventModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface DiscoverEventsRepository {

    val eventData: StateFlow<DiscoveryEventModel?>

    fun close()
    suspend fun searchEvents(eventName: String)

}