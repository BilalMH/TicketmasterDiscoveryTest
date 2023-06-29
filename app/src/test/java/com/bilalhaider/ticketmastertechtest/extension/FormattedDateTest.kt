package com.bilalhaider.ticketmastertechtest.extension

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FormattedDateTest {

    private val dates = listOf(
        "2023-06-21" to "21 June 2023",
        "1967-01-11" to "11 January 1967",
        "2021-02-28" to "28 February 2021",
        "1500-03-01" to "01 March 1500",
        "1111-04-10" to "10 April 1111",
        "1234-05-16" to "16 May 1234",
        "2101-06-18" to "18 June 2101",
        "2000-07-30" to "30 July 2000",
        "1992-02-23" to "23 February 1992",
        "1987-11-09" to "09 November 1987",
    )

    @Test
    fun `format date to readable format`() {
        dates.forEach {
            assertEquals(
                it.second,
                it.first.toReadableDate()
            )
        }
    }

}