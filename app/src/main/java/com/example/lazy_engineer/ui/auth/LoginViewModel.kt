package com.example.lazy_engineer.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lazy_engineer.data.network.Resource
import com.example.lazy_engineer.data.repository.AuthRepository
import com.example.lazy_engineer.data.responce.LoginResponse
import com.example.lazy_engineer.ui.base.BaseViewModel
import com.example.lazy_engineer.ui.base.ViewModelFactory
import kotlinx.coroutines.launch

class LoginViewModel (
    private val repository: AuthRepository
) :ViewModel() {

    private val _navigateToSignUp = MutableLiveData<Boolean>(false)
    val navigateToSignUp: LiveData<Boolean>
        get() = _navigateToSignUp

    fun navigationComplete(){
        _navigateToSignUp.value = false
    }

    fun onCreateAccountClicked(){
        _navigateToSignUp.value = true
    }

    private val _loginResponse = MutableLiveData<Resource<LoginResponse>>()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = Resource.Loading
        _loginResponse.value = repository.login(email, password)
    }

    fun onLoginClicked(){
        viewModelScope.launch { repository.saveAuthToken("temptoken") }
    }


}
