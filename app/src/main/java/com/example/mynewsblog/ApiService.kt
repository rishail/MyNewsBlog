package com.example.mynewsblog

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("/api/login")
    fun login(@Body loginRequest: LoginRequestModel?): Call<LoginResponseModel?>?

    @GET("v2/everything")
    fun getNews(
        @Query("q") query: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsResponseModel?>?


}