package com.example.mynewsblog.data

import com.example.mynewsblog.BuildConfig
import com.example.mynewsblog.data.api.ApiService
import com.example.mynewsblog.data.model.NewsResponseModel
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun fetchNews(
        query: String = "apple",
        from: String = "2024-06-01",
        to: String = "2024-06-07",
        sortBy: String = "popularity",
        apiKey: String =BuildConfig.API_KEY
    ): NewsResponseModel {

        return apiService.getNews(query, from, to, sortBy, apiKey)

    }
}