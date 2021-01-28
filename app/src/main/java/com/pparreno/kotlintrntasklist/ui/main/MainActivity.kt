package com.pparreno.kotlintrntasklist.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.pparreno.kotlintrntasklist.databinding.ActivityMainBinding
import com.pparreno.kotlintrntasklist.ui.compose.ComposeNoteActivity
import com.pparreno.kotlintrntasklist.ui.main.adapters.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = binding.fab
        fab.setOnClickListener { view ->
            val intent = Intent(this@MainActivity, ComposeNoteActivity::class.java)
            startActivity(intent)
        }
    }
}