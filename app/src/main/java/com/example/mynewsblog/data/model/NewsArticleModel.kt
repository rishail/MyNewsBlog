package com.example.mynewsblog.model

import com.example.mynewsblog.data.model.SourceModel

data class NewsArticleModel(val source: SourceModel,
                            val author: String?,
                            val title: String,
                            val description: String?,
                            val url: String,
                            val urlToImage: String?,
                            val publishedAt: String,
                            val content: String,)
