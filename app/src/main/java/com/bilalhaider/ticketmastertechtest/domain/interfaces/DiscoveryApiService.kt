package com.bilalhaider.ticketmastertechtest.domain.interfaces

import com.bilalhaider.ticketmastertechtest.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.data.remote.models.DiscoverEventsResponse

interface DiscoveryApiService {

    suspend fun discoverEventBySearch(searchParams: String): ServiceResult<DiscoverEventsResponse>

}