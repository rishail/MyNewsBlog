package com.example.mynewsblog.di

import com.example.mynewsblog.BuildConfig
import com.example.mynewsblog.data.api.ApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    // Retrofit instance for login
    single(named("LoginRetrofit")) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.LOGIN_AUTH_URK)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Retrofit instance for news
    single(named("NewsRetrofit")) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.NEWS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // LoginApiService
    single(named("LoginApiService")) {
        get<Retrofit>(named("LoginRetrofit")).create(ApiService::class.java)
    }

    // NewsApiService
    single(named("NewsApiService")) {
        get<Retrofit>(named("NewsRetrofit")).create(ApiService::class.java)
    }
}
