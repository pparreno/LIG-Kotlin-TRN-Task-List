package com.pparreno.kotlintrntasklist.ui.notes.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pparreno.kotlintrntasklist.databinding.ActivityNotesDetailsBinding
import com.pparreno.kotlintrntasklist.room.data.Note
import org.ocpsoft.prettytime.PrettyTime

class NotesDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityNotesDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotesDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val note = intent.getParcelableExtra<Note>(KEY_EXTRA_NOTE)
        note?.let { setViewValues(it) }
    }

    private fun setViewValues(note : Note) {
        viewBinding.titleText.text = note.title
        viewBinding.contentText.text = note.content
        val p = PrettyTime()
        viewBinding.dateText.text = p.format(note.dateCreated)
    }

    companion object {
        const val KEY_EXTRA_NOTE: String = "KEY_EXTRA_NOTE.NotesDetailsActivity"
    }
}