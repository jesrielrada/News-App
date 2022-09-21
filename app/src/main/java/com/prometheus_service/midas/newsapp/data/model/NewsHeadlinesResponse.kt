package com.prometheus_service.midas.newsapp.data.model

data class NewsHeadlinesResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)