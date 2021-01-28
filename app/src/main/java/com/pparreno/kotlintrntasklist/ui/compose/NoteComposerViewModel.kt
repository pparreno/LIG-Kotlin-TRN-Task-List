package com.pparreno.kotlintrntasklist.ui.compose

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.pparreno.kotlintrntasklist.room.data.Note
import com.pparreno.kotlintrntasklist.room.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class NoteComposerViewModel @ViewModelInject constructor(
    private val database : AppDatabase,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {
    var isProcessingComplete: MutableLiveData<Boolean> = MutableLiveData(false)

    fun insertNewNote(note: Note) {
        CoroutineScope(IO).launch {
            database.noteDao().insertNote(note)
            isProcessingComplete.postValue(true)
        }
    }

    class FieldValidator {
        companion object {
            fun validateFieldTexts(
                titleString: String,
                contentString: String,
                listener: ValidationStateListener
            ): Boolean {
                val isValidTitle: Boolean = titleString.isNotEmpty()
                val isValidContent: Boolean = contentString.isNotEmpty()

                listener.onPostFieldsValidation(isValidTitle, isValidContent)

                return isValidTitle && isValidContent
            }
        }
    }
}