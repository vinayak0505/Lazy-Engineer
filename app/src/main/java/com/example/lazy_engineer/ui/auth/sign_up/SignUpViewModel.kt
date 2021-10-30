package com.example.lazy_engineer.ui.auth.sign_up

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    private val _navigateToLoginPage = MutableLiveData<Boolean>(false)
    val navigateToLoginPage: LiveData<Boolean>
        get() = _navigateToLoginPage

    fun onGoToLoginClicked(){
        _navigateToLoginPage.value = true
    }

    fun navigationComplete(){
        _navigateToLoginPage.value = false
    }
}