package com.pparreno.kotlintrntasklist.room.coverters

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }
}