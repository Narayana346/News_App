package com.example.newsapp.di.Module

import com.example.newsapp.api.NewsAPI
import com.example.newsapp.db.ArticleDAO
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.repository.NewsRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {
    @Provides
    fun provideNewsRepository( articleDAO: ArticleDAO, newsAPI: NewsAPI ):NewsRepository{
        return NewsRepositoryImp(articleDAO,newsAPI)
    }
}