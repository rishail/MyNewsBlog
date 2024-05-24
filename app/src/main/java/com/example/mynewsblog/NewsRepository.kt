package com.example.mynewsblog

import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun fetchNews(
        query: String = "apple",
        from: String = "2024-05-20",
        to: String = "2024-05-20",
        sortBy: String = "popularity",
        apiKey: String = "4f5e4f2de7c544228066f19efac3ad9e"
    ): NewsResponseModel {

        return apiService.getNews(query, from, to, sortBy, apiKey)

    }
}