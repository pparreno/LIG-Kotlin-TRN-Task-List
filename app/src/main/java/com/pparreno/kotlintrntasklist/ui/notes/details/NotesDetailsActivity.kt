package com.pparreno.kotlintrntasklist.ui.notes.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pparreno.kotlintrntasklist.databinding.ActivityNotesDetailsBinding

class NotesDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityNotesDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotesDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }

    companion object {
        const val KEY_EXTRA_NOTE: String = "KE_EXTRA_NOTE.NotesDetailsActivity"
    }
}