package com.bilalhaider.ticketmastertechtest.domain.data.remote.interfaces

import com.bilalhaider.ticketmastertechtest.domain.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoverEventsResponse

interface DiscoveryApiService {

    suspend fun discoverEventBySearch(searchParams: String): ServiceResult<DiscoverEventsResponse>

}