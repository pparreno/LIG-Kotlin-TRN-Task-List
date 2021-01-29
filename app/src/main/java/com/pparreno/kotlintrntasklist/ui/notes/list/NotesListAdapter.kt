package com.pparreno.kotlintrntasklist.ui.notes.list

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pparreno.kotlintrntasklist.R
import com.pparreno.kotlintrntasklist.databinding.MergeLayoutNoteViewHeaderBinding
import com.pparreno.kotlintrntasklist.databinding.NoteRecyclerItemBinding
import com.pparreno.kotlintrntasklist.room.data.Note
import com.pparreno.kotlintrntasklist.ui.notes.details.NotesDetailsActivity
import org.ocpsoft.prettytime.PrettyTime

class NotesListAdapter(var activity: Activity, var list: List<Note>) : RecyclerView.Adapter<NotesListAdapter.NotesListItemViewHolder>() {

    lateinit var viewBinding : NoteRecyclerItemBinding
    lateinit var viewMergeBinding : MergeLayoutNoteViewHeaderBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListItemViewHolder {
        viewBinding = NoteRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        viewMergeBinding = MergeLayoutNoteViewHeaderBinding.bind(viewBinding.root)
        return NotesListItemViewHolder(viewBinding.root, viewBinding, viewMergeBinding)
    }

    override fun onBindViewHolder(holder: NotesListItemViewHolder, position: Int) {
        val note = list[position]
        holder.titleText.text = note.title
        holder.contentText.text = note.content

        //Set Time Value
        val p = PrettyTime()
        holder.dateText.text = p.format(note.dateCreated)

        if (position % 2 == 0)
        {
            holder.itemView.rootView.background = ColorDrawable(ContextCompat.getColor(activity, R.color.white))
        } else {
            holder.itemView.rootView.background = ColorDrawable(ContextCompat.getColor(activity, R.color.light_gray))
        }

        //Set Favorite Icon Appearance
        if(note.isFavorite)
        {
            holder.favoriteIcon.setImageResource(R.drawable.ic_favorite)
        } else {
            holder.favoriteIcon.setImageResource(R.drawable.ic_favorite_inactive)
        }

        //Set Important Icon Appearance
        if(note.isImportant)
        {
            holder.importantIcon.setImageResource(R.drawable.ic_label_important)
        } else {
            holder.importantIcon.setImageResource(R.drawable.ic_label_important_outline_inactive)
        }

        //Bind On Click Listener
        holder.itemView.setOnClickListener {
            val intent = Intent(activity, NotesDetailsActivity::class.java)
            intent.putExtra(NotesDetailsActivity.KEY_EXTRA_NOTE, note)
            activity.startActivity(intent)
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

        constructor(itemView: View, viewBinding: NoteRecyclerItemBinding, viewMergeBinding: MergeLayoutNoteViewHeaderBinding) : this(itemView) {
            titleText = viewMergeBinding.titleText
            contentText = viewBinding.contentText
            dateText = viewMergeBinding.dateText
            favoriteIcon = viewMergeBinding.favoriteIcon
            importantIcon = viewMergeBinding.importantIcon
        }
    }
}
