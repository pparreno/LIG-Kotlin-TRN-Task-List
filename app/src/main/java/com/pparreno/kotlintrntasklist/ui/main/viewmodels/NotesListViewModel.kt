package com.pparreno.kotlintrntasklist.ui.main.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.pparreno.kotlintrntasklist.room.data.Note
import com.pparreno.kotlintrntasklist.room.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesListViewModel @ViewModelInject constructor(
    private val database: AppDatabase,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var notesLiveData: MutableLiveData<List<Note>> = MutableLiveData()

    fun fetchNotes() {
        CoroutineScope(Dispatchers.IO).launch {
            val notes = database.noteDao().getAll()
            notesLiveData.postValue(notes)
        }
    }
}