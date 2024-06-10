package com.example.mynewsblog.data.api

import com.example.mynewsblog.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val loginApiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.LOGIN_AUTH_URK)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    val newsApiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.NEWS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }



}
