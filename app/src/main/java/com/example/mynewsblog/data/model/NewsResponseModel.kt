package com.example.mynewsblog.data.model

import com.example.mynewsblog.data.model.NewsArticleModel

data class NewsResponseModel( val status: String,
                              val totalResults: Int,
                              val articles: List<NewsArticleModel>)
