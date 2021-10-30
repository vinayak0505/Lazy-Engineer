package com.example.lazy_engineer.ui.main.file

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lazy_engineer.R
import com.example.lazy_engineer.databinding.FragmentFileBinding

class FileFragment : Fragment() {

    private lateinit var viewModel: FileViewModel
    private lateinit var binding: FragmentFileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFileBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FileViewModel::class.java)
        binding.viewModel = viewModel
        val adapter = FileAdapter(FileClickListener { file ->
            viewModel.onFileClicked(file.id)
        })

        binding.fileRv.adapter = adapter
        viewModel.listOfFile.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        viewModel.navigateToFileDetails.observe(viewLifecycleOwner, {
            it?.let { fileId ->
                viewModel.navigationToFileDetailScreenComplete()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }
}