package com.pparreno.kotlintrntasklist.ui.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.EditText
import com.pparreno.kotlintrntasklist.R
import com.pparreno.kotlintrntasklist.databinding.ActivityComposeNoteBinding

class ComposeNoteActivity : AppCompatActivity() {

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
}