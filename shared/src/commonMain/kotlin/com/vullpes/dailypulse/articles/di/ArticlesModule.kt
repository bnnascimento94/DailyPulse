package com.vullpes.dailypulse.articles.di

import com.vullpes.dailypulse.articles.data.ArticleRepository
import com.vullpes.dailypulse.articles.data.ArticlesDataSource
import com.vullpes.dailypulse.articles.data.ArticlesService
import com.vullpes.dailypulse.articles.application.ListArticlesUsecase
import org.koin.dsl.module

val articlesModule = module{
    single<ArticlesService>{
        ArticlesService(get())
    }

    single<ListArticlesUsecase>{
        ListArticlesUsecase(get())
    }

    single<ArticlesDataSource> { ArticlesDataSource(get()) }

    single<ArticleRepository>{ ArticleRepository(get(),get()) }

}