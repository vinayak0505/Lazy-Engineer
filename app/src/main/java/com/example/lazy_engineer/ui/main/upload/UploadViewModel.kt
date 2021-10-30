package com.example.lazy_engineer.ui.main.upload

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lazy_engineer.ui.main.home.HomeCategory
import com.example.lazy_engineer.ui.main.home.HomeCategoryType
import com.example.lazy_engineer.ui.main.home.listOfHomeCategories

class UploadViewModel : ViewModel() {

    private val _uploadCategories = MutableLiveData<List<HomeCategory>>(listOfHomeCategories)
    val uploadCategories: LiveData<List<HomeCategory>>
        get() = _uploadCategories


    private val _navigateToUploadDetailScreen = MutableLiveData<HomeCategoryType?>()
    val navigateToUploadDetailScreen: LiveData<HomeCategoryType?>
        get() = _navigateToUploadDetailScreen

    fun onCategoryClicked(homeCategoryType: HomeCategoryType) {
        _navigateToUploadDetailScreen.value = homeCategoryType
    }

    fun onNavigationToUploadScreenComplete() {
        _navigateToUploadDetailScreen.value = null
    }
}