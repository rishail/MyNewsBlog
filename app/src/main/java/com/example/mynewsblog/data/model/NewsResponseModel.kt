package com.example.mynewsblog.data.model


data class NewsResponseModel( val status: String,
                              val totalResults: Int,
                              val articles: List<NewsArticleModel>)
