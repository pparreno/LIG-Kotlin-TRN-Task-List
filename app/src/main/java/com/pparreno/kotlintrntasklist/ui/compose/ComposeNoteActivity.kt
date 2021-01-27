package com.pparreno.kotlintrntasklist.ui.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.pparreno.kotlintrntasklist.R
import com.pparreno.kotlintrntasklist.databinding.ActivityComposeNoteBinding

class ComposeNoteActivity : AppCompatActivity(), ValidationStateListener {

    lateinit var titleField : EditText
    lateinit var contentField : EditText

    lateinit var binding :  ActivityComposeNoteBinding

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
            NoteComposerViewModel.FieldValidator.validateFieldTexts(titleField.text.toString(), contentField.text.toString(), this)
        }
        return true
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

}