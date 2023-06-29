package com.bilalhaider.ticketmastertechtest.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bilalhaider.ticketmastertechtest.domain.data.local.db.AppDatabase
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoveryEventModel
import com.bilalhaider.ticketmastertechtest.domain.repository.interfaces.DiscoverEventsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchEventsViewModel @Inject constructor(
    private val discoverEventsRepository: DiscoverEventsRepository,
    eventsDatabase: AppDatabase
): ViewModel() {

    val events: StateFlow<List<DiscoveryEventModel>> = eventsDatabase.eventDao().getEvents()

    suspend fun searchForEvent(eventName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            discoverEventsRepository.searchEvents(eventName)
        }
    }

}