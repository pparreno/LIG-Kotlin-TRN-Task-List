package com.pparreno.kotlintrntasklist.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.pparreno.kotlintrntasklist.room.data.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): List<Note>
}