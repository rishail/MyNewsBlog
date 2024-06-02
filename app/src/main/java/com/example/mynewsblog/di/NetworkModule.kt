package com.example.mynewsblog.di

import com.example.mynewsblog.data.LoginRepository
import com.example.mynewsblog.data.api.RetrofitClient
import com.example.mynewsblog.data.NewsRepository
import com.example.mynewsblog.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(): RetrofitClient {
        return RetrofitClient()
    }

    @Provides
    @Singleton
    @Named("LoginApiService")
    fun provideLoginApiService(retrofitClient: RetrofitClient): ApiService {
        return retrofitClient.loginApiService
    }

    @Provides
    @Singleton
    @Named("NewsApiService")
    fun provideNewsApiService(retrofitClient: RetrofitClient): ApiService {
        return retrofitClient.newsApiService
    }

    @Provides
    @Singleton
    fun provideLoginRepository(@Named("LoginApiService") apiService: ApiService): LoginRepository {
        return LoginRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(@Named("NewsApiService") apiService: ApiService): NewsRepository {
        return NewsRepository(apiService)
    }
}