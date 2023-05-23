package com.example.newsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (
    tableName = "articles"
)

data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val category: List<String>,
    val content: String,
    val country: List<String>,
    val creator: Any,
    val description: String,
    val image_url: String,
    val keywords: List<String>,
    val language: String,
    val link: String,
    val pubDate: String,
    val source_id: String,
    val title: String,
    val video_url: Any
)