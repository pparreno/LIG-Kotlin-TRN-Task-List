package com.pparreno.kotlintrntasklist.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pparreno.kotlintrntasklist.room.data.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    suspend fun getAll(): List<Note>

    @Insert
    suspend fun insertNote(note : Note)
}