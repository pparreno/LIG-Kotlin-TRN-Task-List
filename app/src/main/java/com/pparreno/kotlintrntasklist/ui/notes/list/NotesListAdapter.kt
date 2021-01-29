package com.pparreno.kotlintrntasklist.ui.notes.list

import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pparreno.kotlintrntasklist.R
import com.pparreno.kotlintrntasklist.databinding.NoteRecyclerItemBinding
import com.pparreno.kotlintrntasklist.room.data.Note
import org.ocpsoft.prettytime.PrettyTime

class NotesListAdapter(var activity: Activity, var list: List<Note>) : RecyclerView.Adapter<NotesListAdapter.NotesListItemViewHolder>() {

    lateinit var viewBinding : NoteRecyclerItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListItemViewHolder {
        viewBinding = NoteRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return NotesListItemViewHolder(viewBinding.root, viewBinding)
    }

    override fun onBindViewHolder(holder: NotesListItemViewHolder, position: Int) {
        val note = list.get(position)
        holder.titleText.text = note.title
        holder.contentText.text = note.content
        val p = PrettyTime()
        holder.dateText.text = p.format(note.dateCreated)
        if (position % 2 == 0)
        {
            holder.itemView.rootView.background = ColorDrawable(ContextCompat.getColor(activity, R.color.white))
        } else {
            holder.itemView.rootView.background = ColorDrawable(ContextCompat.getColor(activity, R.color.light_gray))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class NotesListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var titleText : TextView
        lateinit var contentText : TextView
        lateinit var dateText : TextView
        lateinit var favoriteIcon : ImageView
        lateinit var importantIcon : ImageView

        constructor(itemView: View, viewBinding: NoteRecyclerItemBinding) : this(itemView) {
            titleText = viewBinding.titleText
            contentText = viewBinding.contentText
            dateText = viewBinding.dateText
            favoriteIcon = viewBinding.favoriteIcon
            importantIcon = viewBinding.importantIcon
        }

    }
}
