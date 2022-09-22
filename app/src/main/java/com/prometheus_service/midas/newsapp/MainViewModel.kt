package com.prometheus_service.midas.newsapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prometheus_service.midas.newsapp.main.MainRepository
import com.prometheus_service.midas.newsapp.util.DispatcherProvider
import com.prometheus_service.midas.newsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {


    private val _state = mutableStateOf(NewsState())
    val state : State<NewsState> = _state

    init {
        loadNewsHeadlines("us")
    }


    fun loadNewsHeadlines(country: String) {
        viewModelScope.launch(dispatcherProvider.io) {
            when (val newsResponse = repository.getHeadlines(country)) {
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        newsArticles = null,
                        isLoading = false,
                        isError = true
                    )
                }
                is Resource.Success -> {
                    val result = newsResponse.data?.articles
                    if (result != null) {
                        Log.d("TEST", "Resource.Success")
                        _state.value = state.value.copy(
                            newsArticles = result.toList(),
                            isLoading = false,
                            isError = false
                        )
                        Log.d("TEST", state.value.newsArticles.toString())
                    } else {
                        Log.d("TEST", "Resource.Else")
                        _state.value = state.value.copy(
                            newsArticles = null,
                            isLoading = false,
                            isError = true
                        )
                    }
                }
            }
        }
    }
}