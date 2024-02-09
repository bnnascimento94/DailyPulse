package com.vullpes.dailypulse.android.di

import com.vullpes.dailypulse.android.screens.article.ArticlesViewModel
import com.vullpes.dailypulse.android.screens.source.SourceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        ArticlesViewModel(get())
    }
    viewModel {
        SourceViewModel(get())
    }
}