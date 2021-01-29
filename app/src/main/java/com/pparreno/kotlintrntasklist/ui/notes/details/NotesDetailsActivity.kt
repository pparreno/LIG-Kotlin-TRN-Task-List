package com.pparreno.kotlintrntasklist.ui.notes.details

import android.app.Activity
import android.os.Bundle
import com.pparreno.kotlintrntasklist.databinding.ActivityNotesDetailsBinding

class NotesDetailsActivity : Activity() {
    lateinit var viewBinding : ActivityNotesDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotesDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}