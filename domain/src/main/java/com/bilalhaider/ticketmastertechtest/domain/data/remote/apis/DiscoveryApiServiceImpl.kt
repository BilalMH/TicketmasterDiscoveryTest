package com.bilalhaider.ticketmastertechtest.domain.data.remote.apis

import com.bilalhaider.ticketmastertechtest.domain.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.domain.data.local.db.AppDatabase
import com.bilalhaider.ticketmastertechtest.domain.data.remote.interfaces.DiscoveryApiService
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoverEventsResponse
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoveryEventModel
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.request.get
import java.util.Locale
import javax.inject.Inject

// Implementation of DiscoverApiService interface and inherits KtorApi open class
class DiscoveryApiServiceImpl @Inject constructor(): KtorApi(Android.create()), DiscoveryApiService {

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

//                addToDatabase(discoverApiResponse.discoveryEvent)

                ServiceResult.Success(discoverApiResponse)
            }

        } catch (error: Exception) {
            ServiceResult.Error("Search Event Error: ", error.message ?: "Network Error")
        }
}