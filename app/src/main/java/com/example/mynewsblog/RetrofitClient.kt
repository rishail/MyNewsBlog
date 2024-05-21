package com.example.mynewsblog

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private val LOGIN_URL = "https://reqres.in/"
    private  val NEWS_URL = "https://newsapi.org/"

    val loginApiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(LOGIN_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    val newsApiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(NEWS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

//    var apiService: ApiService

//    init {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(LOGIN_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        apiService = retrofit.create(ApiService::class.java)
//    }

}
