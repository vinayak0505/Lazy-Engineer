package com.example.lazy_engineer.data.network

import com.example.lazy_engineer.data.responce.ErrorResponse


sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(val error: ErrorResponse) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}