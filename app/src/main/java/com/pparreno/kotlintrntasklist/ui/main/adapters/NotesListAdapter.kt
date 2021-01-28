package com.pparreno.kotlintrntasklist.ui.main.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pparreno.kotlintrntasklist.room.data.Note

class NotesListAdapter(var activity : Activity, var list: List<Note>) : RecyclerView.Adapter<NotesListAdapter.NotesListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NotesListItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class NotesListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var titleText : TextView
        lateinit var contentText : TextView
        lateinit var favoriteIcon : ImageView
        lateinit var importantIcon : ImageView
    }
}