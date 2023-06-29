package com.bilalhaider.ticketmastertechtest.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bilalhaider.ticketmastertechtest.domain.data.local.db.AppDatabase
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoveryEventModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.EventModel
import com.bilalhaider.ticketmastertechtest.domain.repository.interfaces.DiscoverEventsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchEventsViewModel @Inject constructor(
    private val discoverEventsRepository: DiscoverEventsRepository,
    private val eventsDatabase: AppDatabase
): ViewModel() {

    private val _loadingState = MutableStateFlow(LoadingState.IDLE)
    val loadingState = _loadingState.asStateFlow()

    val searchedEvents: StateFlow<DiscoveryEventModel?>
        get() = discoverEventsRepository.eventData

    val savedEvents : StateFlow<List<EventModel>> =
        eventsDatabase
            .eventDao()
            .getEvents()
            .map { it }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Lazily,
                initialValue = emptyList()
            )

    private val _events: MutableStateFlow<List<EventModel>> = MutableStateFlow(emptyList())
    val events = _events.asStateFlow()

    fun searchForEvent(eventName: String) {
        _loadingState.value = LoadingState.LOADING
        viewModelScope.launch(Dispatchers.IO) {
            discoverEventsRepository.searchEvents(eventName)

            searchedEvents.value?.events?.takeUnless { it.isEmpty() }?.let {
                updateEventsList(it)
            }

            _loadingState.value = LoadingState.COMPLETED
        }
    }

    fun addEventToDatabase(event: EventModel) {
        viewModelScope.launch(Dispatchers.IO) {
            eventsDatabase.eventDao().insertEvent(event)
        }
    }

    fun updateEventsList(events: List<EventModel>) {
        _loadingState.value = LoadingState.LOADING
        _events.value = events
        _loadingState.value = LoadingState.COMPLETED
    }
}

enum class LoadingState {
    IDLE,
    LOADING,
    COMPLETED
}