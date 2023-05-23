package com.example.newsapp.repository

import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.db.ArticleDao
import com.example.newsapp.db.ArticleDatabase


class NewsRepository(db: ArticleDatabase) {
    suspend fun getNews(category: String, q: String) =
        RetrofitInstance.api.news(category,q)
}