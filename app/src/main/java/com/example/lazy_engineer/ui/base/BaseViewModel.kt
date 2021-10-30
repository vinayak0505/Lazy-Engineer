package com.example.lazy_engineer.ui.base

import androidx.lifecycle.ViewModel
import com.example.lazy_engineer.data.network.UserApi
import com.example.lazy_engineer.data.repository.BaseRepository

abstract class BaseViewModel(
    private val repository: BaseRepository
): ViewModel() {

    suspend fun logout(api: UserApi) = repository.logout(api)
}