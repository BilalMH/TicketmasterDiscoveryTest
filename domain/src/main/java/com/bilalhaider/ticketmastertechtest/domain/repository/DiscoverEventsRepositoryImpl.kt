package com.bilalhaider.ticketmastertechtest.domain.repository

import com.bilalhaider.ticketmastertechtest.domain.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.domain.data.local.db.AppDatabase
import com.bilalhaider.ticketmastertechtest.domain.data.remote.apis.DiscoveryApiServiceImpl
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoverEventsResponse
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoveryEventModel
import com.bilalhaider.ticketmastertechtest.domain.repository.interfaces.DiscoverEventsRepository
import javax.inject.Inject

class DiscoverEventsRepositoryImpl @Inject constructor(
    private val eventsDatabase: AppDatabase,
    private val discoveryApiService: DiscoveryApiServiceImpl
) : DiscoverEventsRepository {

    override fun close() {
        discoveryApiService.close()
    }

    override suspend fun searchEvents(eventName: String) {
        discoveryApiService.discoverEventBySearch(eventName).run {
            if (this is ServiceResult.Success<DiscoverEventsResponse>) {
                addToDatabase(data.discoveryEvent)
            }
        }
    }

    private fun addToDatabase(discoveryEventModel: DiscoveryEventModel) {
        try {
            eventsDatabase.eventDao().insertEvent(discoveryEventModel)
        } catch (e: Exception) {
            // TODO: Fix Log.e not being mocked error
//            Log.e("DiscoveryApiServiceImpl", "addToDatabase() -> ${e.message}")
        }
    }
}