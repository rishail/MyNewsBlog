package com.example.mynewsblog

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val retrofitClient = RetrofitClient()

    @Provides
    @Singleton
    fun provideLoginApiService():ApiService {

        return retrofitClient.loginApiService
    }

    @Provides
    @Singleton
    fun provideNewsApiService(): ApiService {
        return retrofitClient.newsApiService
    }

    @Provides
    @Singleton
    fun provideLoginRepository(apiService: ApiService): LoginRepository {
        return LoginRepository(apiService)
    }



}