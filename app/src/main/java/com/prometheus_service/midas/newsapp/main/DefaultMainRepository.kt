package com.prometheus_service.midas.newsapp.main

import com.prometheus_service.midas.newsapp.Constants.API_KEY
import com.prometheus_service.midas.newsapp.data.NewsApi
import com.prometheus_service.midas.newsapp.data.model.NewsHeadlinesResponse
import com.prometheus_service.midas.newsapp.util.Resource
import java.lang.Exception
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: NewsApi
): MainRepository {
    override suspend fun getHeadlines(
        apiKey: String,
        country: String
    ): Resource<NewsHeadlinesResponse> {
        return try {
            val response = api.getHeadlines(API_KEY, country)
            val result = response.body()
            if(response.isSuccessful && result != null){
                Resource.Success(result)
            }else{
                Resource.Error(response.message())
            }

        }catch (e: Exception){
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}