package com.example.lazy_engineer.data.repository

import com.example.lazy_engineer.data.responce.ErrorResponse
import com.example.lazy_engineer.data.network.Resource
import com.example.lazy_engineer.data.network.UserApi
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> kotlin.runCatching {
                        val moshi: Moshi = Moshi.Builder().build()
                        val adapter: JsonAdapter<ErrorResponse> =
                            moshi.adapter(ErrorResponse::class.java)
                        val errorResponse =
                            adapter.fromJson(throwable.response()!!.errorBody()!!.string())
                        Resource.Failure(errorResponse!!)
                    }.getOrElse {
                        Resource.Failure(ErrorResponse("temp error"))
                    }
                    else -> Resource.Failure(ErrorResponse("temp error"))
                }
            }
        }
    }

    suspend fun logout(api: UserApi) = safeApiCall {
        api.logout()
    }
}
