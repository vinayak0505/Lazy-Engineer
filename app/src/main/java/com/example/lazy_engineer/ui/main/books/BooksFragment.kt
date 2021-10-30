package com.example.lazy_engineer.ui.main.books

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lazy_engineer.R
import com.example.lazy_engineer.databinding.FragmentBooksBinding

class BooksFragment : Fragment() {
    private lateinit var viewModel: BooksViewModel
    private lateinit var binding: FragmentBooksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBooksBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(BooksViewModel::class.java)
        binding.booksViewModel = viewModel

        val adapter = BookAdapter(BookClickListener {
            viewModel.onBookClicked(it.id)
        })

        binding.booksRv.adapter = adapter
        viewModel.listOfBooks.observe(viewLifecycleOwner, { books ->
            adapter.submitList(books)
        })

        viewModel.navigateToBookDetailScreen.observe(viewLifecycleOwner, {
            it?.let {
                viewModel.onNavigationToBookDetailScreenComplete()
            }
        })

    }
}