package com.bilalhaider.ticketmastertechtest.domain.repository.interfaces

interface DiscoverEventsRepository {

    fun close()
    suspend fun searchEvents(eventName: String)

}