package com.bilalhaider.ticketmastertechtest.domain.data.local.db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.bilalhaider.ticketmastertechtest.domain.data.local.db.dao.DiscoveryEventDao
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.DiscoveryEventModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.sampleEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch

@RunWith(AndroidJUnit4::class)
@SmallTest
class DiscoveryEventDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var eventDao: DiscoveryEventDao

    /**
     * Creating a mock database and eventDao for testing
     */
    @Before
    fun setupDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).addTypeConverter(EventTypeConverters()).build()

        eventDao = database.eventDao()
    }

    @Test
    fun insertEvent_returnTrue() = runBlocking {
        val event = DiscoveryEventModel(id = 1, events = listOf(sampleEvent))
        eventDao.insertEvent(event)

        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            eventDao.getEvents().collect {
                assertThat(it).contains(event)
                latch.countDown()
            }
        }

        latch.await()
        job.cancelAndJoin()
    }

    @Test
    fun insertEvent_conflictResolution_replace_returnTrue() = runBlocking {
        // Insert event with id of 1
        val event = DiscoveryEventModel(id = 1, events = listOf(sampleEvent))
        eventDao.insertEvent(event)

        // Insert another event with id of 1 which should replace the one above
        val updatedEvent = DiscoveryEventModel(id = 1, events = emptyList())
        eventDao.insertEvent(updatedEvent)

        // Getting event and assert if it is equal to the updated event
        val result = eventDao.getOneEvent(requireNotNull(updatedEvent.id)) // Non-null assertion as for testing I know this is Not Null
        assertThat(result.events).isEmpty()
    }

    @Test
    fun deleteEvent_returnTrue() = runBlocking {
        val event = DiscoveryEventModel(id = 1, events = listOf(sampleEvent))
        val secondEvent = DiscoveryEventModel(id = 2, events = listOf(sampleEvent))

        eventDao.insertEvent(event)
        eventDao.insertEvent(secondEvent)

        eventDao.delete(event)

        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            eventDao.getEvents().collect {
                assertThat(it).doesNotContain(event)
                latch.countDown()
            }
        }

        latch.await()
        job.cancelAndJoin()
    }

    @After
    fun closeDatabase() {
        database.close()
    }

}