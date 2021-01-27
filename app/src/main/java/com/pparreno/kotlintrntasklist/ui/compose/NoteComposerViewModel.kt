package com.pparreno.kotlintrntasklist.ui.compose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pparreno.kotlintrntasklist.room.data.Note

class NoteComposerViewModel : ViewModel() {

    var isProcessing : MutableLiveData<Boolean> = MutableLiveData(false)

    fun insertNewNote(note : Note)
    {

    }


    class FieldValidator {

        companion object {
            fun validateFieldTexts(titleString : String, contentString : String , listener : ValidationStateListener) : Boolean {

                val isValidTitle : Boolean = titleString.isNotEmpty()
                val isValidContent : Boolean = contentString.isNotEmpty()

                listener.onPostFieldsValidation(isValidTitle, isValidContent)

                return isValidTitle && isValidContent
            }
        }

    }
}