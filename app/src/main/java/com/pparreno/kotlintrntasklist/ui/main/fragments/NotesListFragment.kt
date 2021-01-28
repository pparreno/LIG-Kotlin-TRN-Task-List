package com.pparreno.kotlintrntasklist.ui.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pparreno.kotlintrntasklist.R
import com.pparreno.kotlintrntasklist.databinding.FragmentRecyclerlistBinding
import com.pparreno.kotlintrntasklist.ui.main.viewmodels.NotesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesListFragment: Fragment() {
    lateinit var viewBinding : FragmentRecyclerlistBinding
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
        viewBinding.recyclerView
        return root
    }

    override fun onStart() {
        super.onStart()
        this.viewModel.notesLiveData.observe(this, {
            Log.d(TAG, "Size of notes list: " + it.size)
        })
        this.viewModel.fetchNotes()
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