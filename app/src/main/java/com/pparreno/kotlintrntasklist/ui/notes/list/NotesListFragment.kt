package com.pparreno.kotlintrntasklist.ui.notes.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pparreno.kotlintrntasklist.R
import com.pparreno.kotlintrntasklist.databinding.FragmentRecyclerlistBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesListFragment: Fragment() {
    lateinit var viewBinding : FragmentRecyclerlistBinding
    lateinit var recyclerView : RecyclerView
    lateinit var notesAdapter : NotesListAdapter
    val viewModel : NotesListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_recyclerlist, container, false)
        viewBinding = FragmentRecyclerlistBinding.bind(root)
        recyclerView = viewBinding.recyclerView
        return root
    }

    override fun onStart() {
        super.onStart()
        this.viewModel.notesLiveData.observe(this, {
            Log.d(TAG, "Size of notes list: " + it.size)
            notesAdapter.list = it
            notesAdapter.notifyDataSetChanged()
        })
        this.viewModel.fetchNotes()
        // finally, data bind the recycler view with adapter
        notesAdapter = NotesListAdapter(requireActivity(), ArrayList())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = notesAdapter
    }

    companion object {
        const val TAG : String = "NotesListFragment"
        /**
         * Returns a new instance of this fragment
         **/
        @JvmStatic
        fun newInstance(): NotesListFragment {
            return NotesListFragment().apply {
                arguments = Bundle().apply {

                }
            }
        }
    }
}