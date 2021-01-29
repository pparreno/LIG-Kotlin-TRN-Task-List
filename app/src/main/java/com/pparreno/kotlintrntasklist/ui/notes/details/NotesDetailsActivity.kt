package com.pparreno.kotlintrntasklist.ui.notes.details

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pparreno.kotlintrntasklist.R
import com.pparreno.kotlintrntasklist.constants.ComposerState
import com.pparreno.kotlintrntasklist.databinding.ActivityNotesDetailsBinding
import com.pparreno.kotlintrntasklist.databinding.MergeLayoutNoteViewHeaderBinding
import com.pparreno.kotlintrntasklist.room.data.Note
import org.ocpsoft.prettytime.PrettyTime

class NotesDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityNotesDetailsBinding
    lateinit var mergeViewBinding : MergeLayoutNoteViewHeaderBinding

    @ComposerState.ComposerStateDef
    var composerState : String = ComposerState.VIEWING_STATE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotesDetailsBinding.inflate(layoutInflater)
        mergeViewBinding = MergeLayoutNoteViewHeaderBinding.bind(viewBinding.root)
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
                    viewBinding.editingScrollview.visibility = View.VISIBLE
                    viewBinding.viewingScrollview.visibility = View.GONE
                    invalidateOptionsMenu()
                }
            }
        } else {
            if(item.itemId == R.id.menu_item_save)
            {
                Log.d(TAG, "Save option selected")
                composerState = ComposerState.VIEWING_STATE

                viewBinding.editingScrollview.visibility = View.GONE
                viewBinding.viewingScrollview.visibility = View.VISIBLE
                invalidateOptionsMenu()
            }
        }

        return true
    }

    private fun setViewValues(note : Note) {
        mergeViewBinding.titleText.text = note.title
        viewBinding.contentText.text = note.content
        val p = PrettyTime()
        mergeViewBinding.dateText.text = p.format(note.dateCreated)
        viewBinding.includedComposerLayout.composeLabel.text = resources.getString(R.string.edit_note)
        viewBinding.includedComposerLayout.titleInputText.setText(note.title)
        viewBinding.includedComposerLayout.contentInputText.setText(note.content)
    }

    companion object {
        const val KEY_EXTRA_NOTE: String = "KEY_EXTRA_NOTE.NotesDetailsActivity"
        const val TAG: String = "NotesDetailsActivity"
    }
}