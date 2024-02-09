package com.vullpes.dailypulse.di

import com.vullpes.dailypulse.articles.application.ListArticlesUsecase
import com.vullpes.dailypulse.sources.ListSourceUsecase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin(){
    val modules = sharedKoinModules + databaseModule

    startKoin {
        modules(modules)
    }

}

class ArticleInjector: KoinComponent{
    val listArticlesUsecase: ListArticlesUsecase by inject()

}

class SourcesInjector : KoinComponent {
    val listSourceUsecase: ListSourceUsecase by inject()
}