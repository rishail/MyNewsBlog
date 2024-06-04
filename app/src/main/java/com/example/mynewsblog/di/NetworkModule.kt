package com.example.mynewsblog.di

import com.example.mynewsblog.BuildConfig
import com.example.mynewsblog.data.api.ApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    single(named("LoginRetrofit")) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.LOGIN_AUTH_URK)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single(named("NewsRetrofit")) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.NEWS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single(named("LoginApiService")) {
        get<Retrofit>(named("LoginRetrofit")).create(ApiService::class.java)
    }

    single(named("NewsApiService")) {
        get<Retrofit>(named("NewsRetrofit")).create(ApiService::class.java)
    }
}
