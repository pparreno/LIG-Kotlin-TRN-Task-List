package com.pparreno.kotlintrntasklist.ui.compose

interface ValidationStateListener {
    fun onPostFieldsValidation(validTitle: Boolean, validContent: Boolean)
}