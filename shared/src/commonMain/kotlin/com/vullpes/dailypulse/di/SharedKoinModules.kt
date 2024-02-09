package com.vullpes.dailypulse.di

import com.vullpes.dailypulse.articles.di.articlesModule
import com.vullpes.dailypulse.sources.di.sourcesModule


val sharedKoinModules = listOf(
    articlesModule,
    networkModule,
    sourcesModule
)