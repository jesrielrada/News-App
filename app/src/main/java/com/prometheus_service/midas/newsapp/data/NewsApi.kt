package com.prometheus_service.midas.newsapp.data

import com.prometheus_service.midas.newsapp.data.model.NewsHeadlinesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsApi {
    @GET("/v2/top-headlines")
    suspend fun getHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String
    ): Response<NewsHeadlinesResponse>
}