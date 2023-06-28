package com.bilalhaider.ticketmastertechtest.data.remote.apis

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.bilalhaider.ticketmastertechtest.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.data.local.db.AppDatabase
import com.bilalhaider.ticketmastertechtest.data.local.db.dao.LocalDiscoveryEvent
import com.bilalhaider.ticketmastertechtest.data.remote.models.DiscoverEventsResponse
import com.bilalhaider.ticketmastertechtest.data.remote.models.DiscoveryEventModel
import com.bilalhaider.ticketmastertechtest.domain.interfaces.DiscoveryApiService
import com.bilalhaider.ticketmastertechtest.util.toApiError
import io.ktor.client.call.body
import io.ktor.client.request.get
import java.util.Locale
import javax.inject.Inject

// Implementation of DiscoverApiService interface and inherits KtorApi abstract class

class DiscoveryApiServiceImpl @Inject constructor(
    val eventDatabase: AppDatabase
): KtorApi(), DiscoveryApiService {

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

                addToDatabase(discoverApiResponse.discoveryEvent)

                ServiceResult.Success(discoverApiResponse)
            }

        } catch (error: Exception) {
            error.toApiError<DiscoverEventsResponse>()
        }

    private fun addToDatabase(discoveryEventModel: DiscoveryEventModel) {
        try {
            eventDatabase.eventDao().insertEvent(discoveryEventModel)
        } catch (e: Exception) {
            // TODO: Fix Log.e not being mocked causing error
//            Log.e("DiscoveryApiServiceImpl", "addToDatabase() -> ${e.message}")
        }
    }
}