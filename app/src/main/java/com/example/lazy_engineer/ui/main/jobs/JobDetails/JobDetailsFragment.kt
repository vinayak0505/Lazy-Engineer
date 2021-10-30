package com.example.lazy_engineer.ui.main.jobs.JobDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lazy_engineer.R

class JobDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = JobDetailsFragment()
    }

    private lateinit var viewModel: JobDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_job_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(JobDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}