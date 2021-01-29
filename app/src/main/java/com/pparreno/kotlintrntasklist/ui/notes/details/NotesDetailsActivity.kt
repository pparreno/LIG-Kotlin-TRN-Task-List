package com.pparreno.kotlintrntasklist.ui.notes.details

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pparreno.kotlintrntasklist.R
import com.pparreno.kotlintrntasklist.constants.ComposerState
import com.pparreno.kotlintrntasklist.databinding.ActivityNotesDetailsBinding
import com.pparreno.kotlintrntasklist.room.data.Note
import org.ocpsoft.prettytime.PrettyTime

class NotesDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityNotesDetailsBinding

    @ComposerState.ComposerStateDef
    var composerState : String = ComposerState.VIEWING_STATE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotesDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val note = intent.getParcelableExtra<Note>(KEY_EXTRA_NOTE)
        note?.let { setViewValues(it) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        if(composerState == ComposerState.VIEWING_STATE)
            inflater.inflate(R.menu.note_details_menu, menu)
        else
            inflater.inflate(R.menu.note_dteails_edit_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(composerState == ComposerState.VIEWING_STATE)
        {
            when(item.itemId)
            {
                R.id.menu_item_delete -> {
                   Log.d(TAG, "Delete option selected")
                }
                R.id.menu_item_edit -> {
                    Log.d(TAG, "Edit option selected")
                    composerState = ComposerState.COMPOSING_STATE
                    invalidateOptionsMenu()
                }
            }
        } else {
            if(item.itemId == R.id.menu_item_save)
            {
                Log.d(TAG, "Save option selected")
                composerState = ComposerState.VIEWING_STATE
                invalidateOptionsMenu()
            }
        }

        return true
    }

    private fun setViewValues(note : Note) {
        viewBinding.titleText.text = note.title
        viewBinding.contentText.text = note.content
        val p = PrettyTime()
        viewBinding.dateText.text = p.format(note.dateCreated)
    }

    companion object {
        const val KEY_EXTRA_NOTE: String = "KEY_EXTRA_NOTE.NotesDetailsActivity"
        const val TAG: String = "NotesDetailsActivity"
    }
}