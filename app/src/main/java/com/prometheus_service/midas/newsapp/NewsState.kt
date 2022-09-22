package com.prometheus_service.midas.newsapp

import com.prometheus_service.midas.newsapp.data.model.Article

data class NewsState(
    val newsArticles: List<Article>? = null,
    val isLoading: Boolean = true,
    val isError: Boolean = false
)
