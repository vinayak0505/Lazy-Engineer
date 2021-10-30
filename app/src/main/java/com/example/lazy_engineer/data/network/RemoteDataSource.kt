package com.example.lazy_engineer.data.network

import com.intuit.sdp.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RemoteDataSource() {
    private val BASE_URL = "https://web.whatsapp.com/"
    private val authToken = "qoqiwure"

    private var authBuilder: Retrofit
    private var builder: Retrofit

    init {
        val httpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(OAuthInterceptor("Bearer", authToken))

        val authHttpClient = OkHttpClient().newBuilder()

        if (BuildConfig.DEBUG) {
            // logging level
            val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClient.addInterceptor(interceptor)
            authHttpClient.addInterceptor(interceptor)
        }

        authBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun <Api> buildAuthApi(api: Class<Api>): Api {
        return authBuilder.create(api)
    }

    fun <Api> buildApi(api: Class<Api>): Api {
        return builder.create(api)
    }

    private class OAuthInterceptor(private val tokenType: String, private val accessToken: String) :
        Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            request =
                request.newBuilder().header("Authorization", "$tokenType $accessToken").build()
            return chain.proceed(request)
        }
    }
}
