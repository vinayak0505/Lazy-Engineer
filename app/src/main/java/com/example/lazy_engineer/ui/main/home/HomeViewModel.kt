package com.example.lazy_engineer.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _homeCategories = MutableLiveData<List<HomeCategory>>(listOfHomeCategories)
    val homeCategories: LiveData<List<HomeCategory>>
        get() = _homeCategories

    private val _navigateToCategory = MutableLiveData<HomeCategoryType?>()
    val navigateToCategory: LiveData<HomeCategoryType?>
        get() = _navigateToCategory

    fun onCategoryClicked(type: HomeCategoryType) {
        _navigateToCategory.value = type
    }

    fun onCategoryNavigated() {
        _navigateToCategory.value = null
    }
}