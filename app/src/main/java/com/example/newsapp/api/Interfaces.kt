package com.example.newsapp.api

import com.example.newsapp.model.News
import com.example.newsapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Interfaces {
    @GET("news")
    suspend fun news(
        @Query("category") categoryCode: String,
        @Query("q") searchCode: String,
        @Query("apikey") apikeyCode: String = Constants.API_KEY,
        @Query("country") countryCode: String = "id"
    ): Response<News>
}