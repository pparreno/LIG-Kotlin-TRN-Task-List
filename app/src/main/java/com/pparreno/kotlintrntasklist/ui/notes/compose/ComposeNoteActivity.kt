package com.pparreno.kotlintrntasklist.ui.notes.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.activity.viewModels
import com.pparreno.kotlintrntasklist.R
import com.pparreno.kotlintrntasklist.databinding.ActivityComposeNoteBinding
import com.pparreno.kotlintrntasklist.room.data.Note
import com.pparreno.kotlintrntasklist.ui.views.LoadingDialog
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class ComposeNoteActivity : AppCompatActivity(), ValidationStateListener {
    lateinit var titleField: EditText
    lateinit var contentField: EditText
    lateinit var viewBinding: ActivityComposeNoteBinding


    private val viewModel: NoteComposerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityComposeNoteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        titleField = viewBinding.includedComposerLayout.titleInputText
        contentField = viewBinding.includedComposerLayout.contentInputText

    }


    override fun onStart() {
        super.onStart()
        viewModel.isProcessingComplete.observe(this, {
            Log.d(TAG, "viewModel.isProcessingComplete: $it")
            if (it) {
                this@ComposeNoteActivity.finish()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.compose_note_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_item_save) {
            if (NoteComposerViewModel.FieldValidator.validateFieldTexts(
                    titleField.text.toString(),
                    contentField.text.toString(),
                    this
                )
            ) {
                val note = noteObjectFromFields()
                viewModel.insertNewNote(note)
                Log.d(TAG, "inserted note with room")
            }
        }
        return true
    }

    private fun noteObjectFromFields(): Note {
        val curDate = Date()
        return Note(
            curDate,
            curDate,
            null,
            titleField.text.toString(),
            contentField.text.toString(),
            isImportant = viewBinding.includedComposerLayout.noteImportantSwitch.isChecked,
            isFavorite = viewBinding.includedComposerLayout.noteFavoriteSwitch.isChecked
        )
    }

    override fun onPostFieldsValidation(validTitle: Boolean, validContent: Boolean) {
        if (!validTitle) {
            titleField.error = "Title must not be empty!"
        }

        if (!validContent) {
            contentField.error = "Content must not be empty!"
        }
    }

    companion object {
        const val TAG: String = "ComposeNoteActivitys"
    }
}