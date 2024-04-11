package com.example.newsapp.di.Module

import com.example.newsapp.data.api.NewsAPI
import com.example.newsapp.data.db.ArticleDAO
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.repository.NewsRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {
    @Provides
    fun provideNewsRepository(articleDAO: ArticleDAO, newsAPI: NewsAPI): NewsRepository {
        return NewsRepositoryImp(articleDAO,newsAPI)
    }
}