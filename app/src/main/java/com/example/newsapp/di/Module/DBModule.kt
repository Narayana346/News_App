package com.example.newsapp.di.Module

import android.content.Context
import androidx.room.Room
import com.example.newsapp.data.db.ArticleDAO
import com.example.newsapp.data.db.ArticleDatabase
import com.example.newsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {
    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): ArticleDatabase {
        val builder = Room.databaseBuilder(context.applicationContext,
            ArticleDatabase::class.java,Constants.DATA_BASE_NAME)
        return builder.build()
    }

    @Provides
    @Singleton
    fun providesArticleDao(articleDatabase: ArticleDatabase): ArticleDAO {
        return articleDatabase.getArticleDao()
    }
}