package com.vullpes.dailypulse.sources

import com.vullpes.dailypulse.articles.data.ArticleRaw
import com.vullpes.dailypulse.articles.data.ArticlesDataSource
import com.vullpes.dailypulse.articles.data.ArticlesService

class SourceRepository(private val dataSource: SourcesDataSource, private val service: SourceService) {

    suspend fun getSources():List<SourceRaw>{
        val sourcesDb = dataSource.getAllSources()
        if(sourcesDb.isEmpty()){
            return fetchSources()
        }

        return sourcesDb
    }

    private suspend fun fetchSources(): List<SourceRaw> {
        val fetchSources = service.fetchSources()
        dataSource.insertSource(fetchSources)
        return fetchSources
    }
}