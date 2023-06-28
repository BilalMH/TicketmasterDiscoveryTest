package com.bilalhaider.ticketmastertechtest.data.remote.apis

import com.bilalhaider.ticketmastertechtest.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.data.remote.models.DiscoverEventsResponse
import com.bilalhaider.ticketmastertechtest.domain.interfaces.DiscoveryApiService
import com.bilalhaider.ticketmastertechtest.util.toApiError
import io.ktor.client.call.body
import io.ktor.client.request.get
import java.util.Locale
import javax.inject.Inject

// Implementation of DiscoverApiService interface and inherits KtorApi abstract class

class DiscoveryApiServiceImpl @Inject constructor() : KtorApi(), DiscoveryApiService {

    companion object {
        const val DISCOVER = "$BASE_URL${ApiRoutes.DISCOVERY}"
    }

    override suspend fun discoverEventBySearch(searchParams: String): ServiceResult<DiscoverEventsResponse> =
        try {
            with(client()) {
                val discoverApiResponse = get(DISCOVER) {
                    url {
                        parameters.append("apikey", APP_API_KEY)
                        parameters.append("countryCode", Locale.getDefault().country)
                        parameters.append("keyword", searchParams)
                    }
                }.body<DiscoverEventsResponse>()

                ServiceResult.Success(discoverApiResponse)
            }

        } catch (error: Exception) {
            error.toApiError<DiscoverEventsResponse>()
        }
}