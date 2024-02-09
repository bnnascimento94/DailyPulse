package com.vullpes.dailypulse.android.screens.article

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vullpes.dailypulse.articles.application.Article
import com.vullpes.dailypulse.articles.application.ListArticlesUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ArticlesViewModel(private val listArticlesUsecase: ListArticlesUsecase): ViewModel() {
    private val _articles: MutableStateFlow<List<Article>> = MutableStateFlow(emptyList())
    val articles: StateFlow<List<Article>>  = _articles

    val isLoading = mutableStateOf(false)

    init{
        fetchArticles()
    }


    fun fetchArticles(fetchArticles:Boolean = false) = viewModelScope.launch {
        withContext(Dispatchers.Main){
            isLoading.value = true
        }
        val result = listArticlesUsecase.invoke(fetchArticles)
        _articles.emit(result)
        withContext(Dispatchers.Main){
            isLoading.value = false
        }
    }

}