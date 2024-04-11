package com.example.newsapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.newsapp.data.models.Article
import com.example.newsapp.data.models.NewsResponse
import retrofit2.Response

interface NewsRepository {
    suspend fun getHeadlines(countryCode: String, pageNumber:Int): Response<NewsResponse>

    suspend fun searchNews(searchQuery: String,pageNumber:Int): Response<NewsResponse>

    suspend fun upsert(article: Article):Unit

    fun getFavoriteNews(): LiveData<List<Article>>

    suspend fun deleteArticle(article: Article):Unit
}