package com.prometheus_service.midas.newsapp.util

sealed class Resource<T>(val data: T?, val message: String?) {
    class Success<T>(data: T) : Resource<T>(data, null)
    class Error<T>(message: String?): Resource<T>(null, message)
}