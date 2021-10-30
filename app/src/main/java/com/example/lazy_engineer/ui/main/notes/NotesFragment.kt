package com.example.lazy_engineer.ui.main.notes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lazy_engineer.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private lateinit var viewModel: NotesViewModel
    private lateinit var binding: FragmentNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        binding.notesToolbar.setOnClickListener {
            findNavController().navigateUp()
        }
        val adapter = NotesAdapter(NoteClickListener {

        })

        binding.notesRv.adapter = adapter

        viewModel.listOfNotes.observe(viewLifecycleOwner, { notes ->
            adapter.submitList(notes)
        })
    }
}