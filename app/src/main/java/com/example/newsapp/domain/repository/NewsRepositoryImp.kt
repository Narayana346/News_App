package com.example.newsapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.newsapp.data.api.NewsAPI
import com.example.newsapp.data.db.ArticleDAO
import com.example.newsapp.data.models.Article
import com.example.newsapp.data.models.NewsResponse
import com.example.newsapp.domain.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImp(private val dao: ArticleDAO, private val api : NewsAPI): NewsRepository {
    override suspend fun getHeadlines(countryCode: String, pageNumber:Int): Response<NewsResponse> {
       return api.getHeadlines(countryCode, pageNumber)
    }

    override suspend fun searchNews(searchQuery: String,pageNumber:Int): Response<NewsResponse> {
       return api.searchForNews(searchQuery, pageNumber)
    }

    override suspend fun upsert(article: Article):Unit {
        dao.upsert(article)
    }

    override fun getFavoriteNews(): LiveData<List<Article>> {
        return dao.getAllArticles()
    }

    override suspend fun deleteArticle(article: Article):Unit {
        dao.deleteArticle(article)
    }
}