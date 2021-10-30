package com.example.lazy_engineer.ui.main.books.book_detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lazy_engineer.R
import com.example.lazy_engineer.databinding.FragmentBookDetailsBinding

class BookDetailsFragment : Fragment() {

    private lateinit var viewModel: BookDetailsViewModel
    private lateinit var binding: FragmentBookDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookDetailsBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(BookDetailsViewModel::class.java)
        binding.bookDetailsViewModel = viewModel
    }
}