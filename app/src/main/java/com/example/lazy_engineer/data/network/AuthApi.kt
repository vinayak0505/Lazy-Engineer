package com.example.lazy_engineer.data.network

import com.example.lazy_engineer.data.responce.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("url")
    fun login(
        @Field("email") email:String,
        @Field("password") password:String,
    ) : LoginResponse

}