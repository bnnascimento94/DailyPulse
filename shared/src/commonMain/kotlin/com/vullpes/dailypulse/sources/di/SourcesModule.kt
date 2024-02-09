package com.vullpes.dailypulse.sources.di

import com.vullpes.dailypulse.articles.application.ListArticlesUsecase
import com.vullpes.dailypulse.articles.data.ArticleRepository
import com.vullpes.dailypulse.articles.data.ArticlesDataSource
import com.vullpes.dailypulse.articles.data.ArticlesService
import com.vullpes.dailypulse.sources.ListSourceUsecase
import com.vullpes.dailypulse.sources.SourceRepository
import com.vullpes.dailypulse.sources.SourceService
import com.vullpes.dailypulse.sources.SourcesDataSource
import org.koin.dsl.module

val sourcesModule = module{
    single<SourceService>{
        SourceService(get())
    }

    single<ListSourceUsecase>{
        ListSourceUsecase(get())
    }

    single<SourcesDataSource> { SourcesDataSource(get()) }

    single<SourceRepository>{ SourceRepository(get(),get()) }

}