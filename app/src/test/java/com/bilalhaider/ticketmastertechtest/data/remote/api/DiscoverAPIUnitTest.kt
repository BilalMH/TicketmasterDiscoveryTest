package com.bilalhaider.ticketmastertechtest.data.remote.api

import com.bilalhaider.ticketmastertechtest.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.data.remote.api.creators.ktorSuccessClient
import com.bilalhaider.ticketmastertechtest.data.remote.apis.DiscoveryApiServiceImpl
import io.mockk.every
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions

@OptIn(ExperimentalCoroutinesApi::class)
internal class DiscoverAPIUnitTest {

    /**
    * I use MockK here to use my real DiscoveryApiService class so I
    * can keep testing closer to my actual business logic.
    * This then eliminates the need to create duplicate services that inherit from the same service
    */
    private val discoveryApiService = spyk<DiscoveryApiServiceImpl>()

    @Nested
    internal inner class ReturnSuccess {

        @Test
        fun `discover events from search success response`() = runTest { // Using runTest to run a testing coroutine scope

            every { discoveryApiService.client() } returns ktorSuccessClient

            val results = discoveryApiService.discoverEventBySearch("Sleep Token")

            assertInstanceOf(ServiceResult.Success::class.java, results)

            Assertions.assertEquals(2, (results as ServiceResult.Success).data.discoverEvent.events.size)
        }

    }

}