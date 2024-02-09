package com.vullpes.dailypulse.android.screens.source

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vullpes.dailypulse.articles.application.Article
import com.vullpes.dailypulse.articles.application.ListArticlesUsecase
import com.vullpes.dailypulse.sources.ListSourceUsecase
import com.vullpes.dailypulse.sources.Source
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SourceViewModel(private val listSourceUsecase: ListSourceUsecase): ViewModel() {
    private val _sources: MutableStateFlow<List<Source>> = MutableStateFlow(emptyList())
    val sources: StateFlow<List<Source>> = _sources

    init{
        fetchSources()
    }


    private fun fetchSources() = viewModelScope.launch {
        val result = listSourceUsecase.invoke()
        _sources.emit(result)
    }

}