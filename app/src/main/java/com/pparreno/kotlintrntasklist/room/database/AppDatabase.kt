package com.pparreno.kotlintrntasklist.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pparreno.kotlintrntasklist.room.coverters.Converters
import com.pparreno.kotlintrntasklist.room.data.Note

@Database(entities = [Note::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
}