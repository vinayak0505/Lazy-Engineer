package com.example.lazy_engineer.ui.main.jobs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lazy_engineer.R
import com.example.lazy_engineer.databinding.FragmentJobsBinding

class JobsFragment : Fragment() {

    private lateinit var viewModel: JobsViewModel
    private lateinit var binding: FragmentJobsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJobsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(JobsViewModel::class.java)
        binding.jobsViewModel = viewModel

        binding.jobsTb.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.menu_filter) {
                onFilterSelected()
                true
            } else false
        }

        val adapter = JobsAdapter(JobClickListener { job ->
            viewModel.onJobClicked(job.id)
        })

        binding.jobsRv.adapter = adapter

        viewModel.listOfJobs.observe(viewLifecycleOwner, { jobs ->
            adapter.submitList(jobs)
        })
    }

    private fun onFilterSelected() {

    }
}