package com.example.mynewsblog.data.api

import com.example.mynewsblog.model.LoginRequestModel
import com.example.mynewsblog.model.LoginResponseModel
import com.example.mynewsblog.model.NewsResponseModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/api/login")
    suspend fun login(@Body loginRequest: LoginRequestModel): LoginResponseModel

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") query: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): NewsResponseModel
}