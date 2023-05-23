package com.example.newsapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.News
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModels(val newsRepository: NewsRepository): ViewModel() {
    val news : MutableLiveData<Resource<News>> = MutableLiveData()
    fun getNews(category: String,q: String) = viewModelScope.launch {
        news.postValue(Resource.Loading())
        val response = newsRepository.getNews(category, q)
        news.postValue(handleGetNews(response))
    }

    private fun handleGetNews(response: Response<News>): Resource<News>{
       if (response.isSuccessful){
           response.body()?.let { res ->
               return Resource.Success(res)
           }
       }
        return Resource.Error(response.message())
    }

}