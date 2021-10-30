package com.example.lazy_engineer.ui.main.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {

    private val _navigateToProfileScreen = MutableLiveData<Boolean>()
    val navigateToProfileScreen: LiveData<Boolean>
        get() = _navigateToProfileScreen

    fun onProfileClicked(){
        _navigateToProfileScreen.value = true
    }

    fun onProfileNavigationComplete(){
        _navigateToProfileScreen.value = false
    }
}