package com.example.lazy_engineer.ui.main.jobs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JobsViewModel : ViewModel() {

    val listOfJobs = MutableLiveData(jobs)

    private val _navigateToJobDetailScreen = MutableLiveData<Long?>()
    val navigateToJobDetailScreen: LiveData<Long?>
        get() = _navigateToJobDetailScreen

    fun onJobClicked(jobId: Long) {
        _navigateToJobDetailScreen.value = jobId
    }

    fun onNavigationToJobDetailScreenComplete() {
        _navigateToJobDetailScreen.value = null
    }
}