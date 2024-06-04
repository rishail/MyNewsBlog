package com.example.mynewsblog.model

data class NewsResponseModel( val status: String,
                              val totalResults: Int,
                              val articles: List<NewsArticleModel>)
