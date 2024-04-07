package com.example.newsapp.di.Module

import com.example.newsapp.api.NewsAPI
import com.example.newsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder, httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        okHttpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor)
        return  okHttpClientBuilder.build()
    }

    @Provides
    fun provideOkhttpClientBuilder() = OkHttpClient.Builder()


    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()

    @Provides
    fun providesNewsApi(retrofit: Retrofit):NewsAPI = retrofit.create(NewsAPI::class.java)
}