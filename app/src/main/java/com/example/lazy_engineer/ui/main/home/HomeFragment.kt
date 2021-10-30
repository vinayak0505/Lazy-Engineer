package com.example.lazy_engineer.ui.main.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lazy_engineer.R
import com.example.lazy_engineer.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel

        val adapter = HomeCategoryAdapter(HomeCategoryClickListener { homeCategory ->
            viewModel.onCategoryClicked(homeCategory.homeCategoryType)
        })

        binding.hCategoriesRv.adapter = adapter

        viewModel.homeCategories.observe(viewLifecycleOwner, { listOfHomeCategories ->
            listOfHomeCategories?.let {
                adapter.submitList(it)
            }
        })

        viewModel.navigateToCategory.observe(viewLifecycleOwner, { type ->
            type?.let {
                when (type) {
                    HomeCategoryType.NOTES -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNotesFragment())
                    HomeCategoryType.QUESTION_PAPER -> TODO()
                    HomeCategoryType.FILE -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFileFragment())
                    HomeCategoryType.BOOKS -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToBooksFragment())
                    HomeCategoryType.JOBS -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToJobsFragment())
                }
                viewModel.onCategoryNavigated()
            }
        })
    }
}