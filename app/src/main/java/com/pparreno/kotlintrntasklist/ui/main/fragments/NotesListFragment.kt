package com.pparreno.kotlintrntasklist.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pparreno.kotlintrntasklist.R
import com.pparreno.kotlintrntasklist.databinding.FragmentRecyclerlistBinding

class NotesListFragment: Fragment() {

    lateinit var viewBinding : FragmentRecyclerlistBinding

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

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(): NotesListFragment {
            return NotesListFragment().apply {
                arguments = Bundle().apply {

                }
            }
        }
    }
}