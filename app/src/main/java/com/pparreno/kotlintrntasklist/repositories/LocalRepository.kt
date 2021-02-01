package com.pparreno.kotlintrntasklist.repositories

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pparreno.kotlintrntasklist.room.dao.NoteDao
import com.pparreno.kotlintrntasklist.room.data.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalRepository @Inject constructor(private val noteDao: NoteDao){

    var notesList : MutableLiveData<List<Note>> = MutableLiveData()

    suspend fun fetchNotes() : LiveData<List<Note>> {
        return noteDao.getAll()
    }
}