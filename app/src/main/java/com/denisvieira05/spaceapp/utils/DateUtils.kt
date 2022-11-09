package com.denisvieira05.spaceapp.utils

import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

object DateUtils {

    fun convertTimestampToDate(timestamp: String): Date? {
        val timestamp = Instant.parse(timestamp)
        return Date.from(timestamp)
    }

    fun Date.convertToSimpleDateFormat(): String {
        val sdf = SimpleDateFormat("MMMM dd, yyyy")
        return sdf.format(this)
    }
}