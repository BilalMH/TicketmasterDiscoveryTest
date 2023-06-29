package com.bilalhaider.ticketmastertechtest.extension

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.toReadableDate(): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd")
    val date = formatter.parse(this)
    return SimpleDateFormat("dd LLLL yyyy").format(date)
}