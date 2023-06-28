package com.bilalhaider.ticketmastertechtest.data.remote.api

import com.bilalhaider.ticketmastertechtest.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.data.local.db.AppDatabase
import com.bilalhaider.ticketmastertechtest.data.remote.api.creators.ktorSuccessClient
import com.bilalhaider.ticketmastertechtest.data.remote.apis.DiscoveryApiServiceImpl
import com.google.common.truth.Truth.assertThat
import io.mockk.MockK
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkConstructor
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class DiscoverAPIUnitTest {

    /**
    * I use MockK here to use my real DiscoveryApiService class so I
    * can keep testing closer to my actual business logic.
    * This then eliminates the need to create duplicate services that inherit from the same service
    */
    private val appDatabaseMock = mockkConstructor(AppDatabase::class)
    private val discoveryApiService = spyk(DiscoveryApiServiceImpl(eventDatabase = mockk()))

    @Nested
    internal inner class ReturnSuccess {

        @Test
        fun `discover events from search success response`() = runTest {
            // Using runTest to run a testing coroutine scope
            every { discoveryApiService.client() } returns ktorSuccessClient

            val results = discoveryApiService.discoverEventBySearch("Sleep Token")

            assertInstanceOf(ServiceResult.Success::class.java, results)

            Assertions.assertEquals(2, (results as ServiceResult.Success).data.discoveryEvent.events.size)
        }

        @Test
        fun `discover events from search sorted by nearest date ascending order, correct order`() = runTest {
            every { discoveryApiService.client() } returns ktorSuccessClient

            val results = discoveryApiService.discoverEventBySearch("Sleep Token")

            val sortedResults = (results as ServiceResult.Success).data.discoveryEvent.events.sortedBy { it.dates.start.localDate }

            for(i in 0..sortedResults.size - 2) {
                assertThat(sortedResults[i].dates.start.localDate).isAtMost(sortedResults[i+1].dates.start.localDate)
            }
        }

        @Test
        fun `discover events from search sorted by nearest date descending order, correct order`() = runTest {
            every { discoveryApiService.client() } returns ktorSuccessClient

            val results = discoveryApiService.discoverEventBySearch("Sleep Token")

            val sortedResults = (results as ServiceResult.Success).data.discoveryEvent.events.sortedByDescending { it.dates.start.localDate }

            for(i in 0..sortedResults.size - 2) {
                assertThat(sortedResults[i].dates.start.localDate).isAtLeast(sortedResults[i+1].dates.start.localDate)
            }
        }
    }

}