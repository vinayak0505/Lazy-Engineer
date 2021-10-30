package com.example.lazy_engineer.ui.main.file

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FileViewModel : ViewModel() {

    val listOfFile = MutableLiveData(files)

    private val _navigateToFileDetails = MutableLiveData<Long?>()
    val navigateToFileDetails: LiveData<Long?>
        get() = _navigateToFileDetails

    fun onFileClicked(fileId: Long) {
        _navigateToFileDetails.value = fileId
    }

    fun navigationToFileDetailScreenComplete() {
        _navigateToFileDetails.value = null
    }
}