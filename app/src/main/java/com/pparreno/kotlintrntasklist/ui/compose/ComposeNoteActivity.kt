package com.pparreno.kotlintrntasklist.ui.compose

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
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class ComposeNoteActivity : AppCompatActivity(), ValidationStateListener {

    lateinit var titleField : EditText
    lateinit var contentField : EditText

    lateinit var binding :  ActivityComposeNoteBinding

    val viewModel : NoteComposerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComposeNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        titleField = binding.titleInputText
        contentField = binding.contentInputText
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.compose_note_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_item_save)
        {
            if(NoteComposerViewModel.FieldValidator.validateFieldTexts(titleField.text.toString(), contentField.text.toString(), this))
            {
                val note = noteObjectFromFields()
                viewModel.insertNewNote(note)
                Log.d(TAG, "inserted note with room")
            }
        }
        return true
    }

    private fun noteObjectFromFields(): Note {
        val curDate = Date().time
        return Note(curDate, curDate, null, titleField.text.toString(), contentField.text.toString())
    }

    override fun onPostFieldsValidation(validTitle: Boolean, validContent: Boolean) {
      if(!validTitle)
      {
          titleField.error = "Title must not be empty!"
      }

        if(!validContent)
        {
            contentField.error = "Content must not be empty!"
        }
    }

    companion object {
        const val TAG : String = "ComposeNoteActivitys"
    }

}