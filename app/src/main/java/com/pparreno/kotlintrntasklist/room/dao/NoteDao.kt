package com.pparreno.kotlintrntasklist.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pparreno.kotlintrntasklist.room.data.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): LiveData<List<Note>>

    @Insert
    suspend fun insertNote(note : Note)
}