package com.prometheus_service.midas.newsapp.di

import com.prometheus_service.midas.newsapp.Constants.BASE_URL
import com.prometheus_service.midas.newsapp.data.NewsApi
import com.prometheus_service.midas.newsapp.main.DefaultMainRepository
import com.prometheus_service.midas.newsapp.main.MainRepository
import com.prometheus_service.midas.newsapp.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCurrencyApi() : NewsApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApi::class.java)

    @Singleton
    @Provides
    fun provideRepository(api: NewsApi) : MainRepository = DefaultMainRepository(api)

    @Singleton
    @Provides
    fun provideDispatcherProvide() : DispatcherProvider = object : DispatcherProvider{
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }

}