package com.example.mynewsblog

data class NewsResponseModel( val status: String,
                              val totalResults: Int,
                              val articles: List<NewsArticleModel>)
