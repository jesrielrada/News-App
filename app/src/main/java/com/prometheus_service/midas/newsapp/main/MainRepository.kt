package com.prometheus_service.midas.newsapp.main

import com.prometheus_service.midas.newsapp.data.model.NewsHeadlinesResponse
import com.prometheus_service.midas.newsapp.util.Resource

interface MainRepository {
    suspend fun getHeadlines(country: String) : Resource<NewsHeadlinesResponse>
}