package com.pparreno.kotlintrntasklist.ui.compose

import androidx.lifecycle.ViewModel

class NoteComposerViewModel : ViewModel() {

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