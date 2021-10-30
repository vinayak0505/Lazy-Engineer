package com.example.lazy_engineer.ui.main.upload

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lazy_engineer.R
import com.example.lazy_engineer.databinding.FragmentUploadBinding
import com.example.lazy_engineer.ui.main.home.HomeCategoryAdapter
import com.example.lazy_engineer.ui.main.home.HomeCategoryClickListener
import com.example.lazy_engineer.ui.main.home.HomeCategoryType
import com.example.lazy_engineer.ui.main.home.HomeFragmentDirections

class UploadFragment : Fragment() {

    private lateinit var viewModel: UploadViewModel
    private lateinit var binding: FragmentUploadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUploadBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UploadViewModel::class.java)
        binding.uploadViewModel = viewModel

        val adapter = HomeCategoryAdapter(HomeCategoryClickListener { homeCategory ->
            viewModel.onCategoryClicked(homeCategory.homeCategoryType)
        })

        binding.uCategoriesRv.adapter = adapter
        viewModel.uploadCategories.observe(viewLifecycleOwner, { listOfHomeCategories ->
            listOfHomeCategories?.let {
                adapter.submitList(it)
            }
        })

        viewModel.navigateToUploadDetailScreen.observe(viewLifecycleOwner, { type ->
            type?.let {
                when (type) {
                    HomeCategoryType.NOTES -> findNavController().navigate(UploadFragmentDirections.actionUploadFragmentToUploadNotesFragment())
                    HomeCategoryType.QUESTION_PAPER -> findNavController().navigate(UploadFragmentDirections.actionUploadFragmentToUploadPaperFragment())
                    HomeCategoryType.FILE -> findNavController().navigate(UploadFragmentDirections.actionUploadFragmentToUploadFileFragment())
                    HomeCategoryType.BOOKS -> findNavController().navigate(UploadFragmentDirections.actionUploadFragmentToUploadBookFragment())
                    HomeCategoryType.JOBS -> findNavController().navigate(UploadFragmentDirections.actionUploadFragmentToUploadJobFragment())
                }
                viewModel.onNavigationToUploadScreenComplete()
            }
        })
    }
}