package com.pparreno.kotlintrntasklist.ui.notes.list

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.pparreno.kotlintrntasklist.repositories.LocalRepository
import com.pparreno.kotlintrntasklist.room.data.Note
import com.pparreno.kotlintrntasklist.room.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesListViewModel @ViewModelInject constructor(
    private val repository: LocalRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var notesLiveData: MutableLiveData<List<Note>> = MutableLiveData()

    val observer = Observer<List<Note>> {
        notesLiveData.postValue(it)
    }

    fun fetchNotes() {
            CoroutineScope(Dispatchers.Main).launch {
               repository.fetchNotes().observeForever(observer)
            }
    }

    override fun onCleared() {
        notesLiveData.removeObserver(observer)
        super.onCleared()
    }
}