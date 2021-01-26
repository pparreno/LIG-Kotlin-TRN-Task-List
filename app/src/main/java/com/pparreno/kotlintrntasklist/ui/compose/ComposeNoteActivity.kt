package com.pparreno.kotlintrntasklist.ui.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.pparreno.kotlintrntasklist.R

class ComposeNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose_note)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.compose_note_menu, menu)
        return true
    }
}