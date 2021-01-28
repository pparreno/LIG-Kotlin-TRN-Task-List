package com.pparreno.kotlintrntasklist.ui.notes.compose

interface ValidationStateListener {
    fun onPostFieldsValidation(validTitle: Boolean, validContent: Boolean)
}