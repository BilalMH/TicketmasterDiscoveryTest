package com.bilalhaider.ticketmastertechtest.data.remote.interfaces

import com.bilalhaider.ticketmastertechtest.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.data.remote.models.DiscoverEventsResponse

interface DiscoveryApiService {

    suspend fun discoverEventBySearch(searchParams: String): ServiceResult<DiscoverEventsResponse>

}