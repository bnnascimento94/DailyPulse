package com.vullpes.dailypulse.articles.data

class ArticleRepository(private val dataSource: ArticlesDataSource, private val service: ArticlesService) {

    suspend fun getArticles(forceFetch: Boolean):List<ArticleRaw>{
        if(forceFetch){
            dataSource.clearArticles()
           return fetchArticles()
        }
        val articlesDb = dataSource.getAllArticles()
        if(articlesDb.isEmpty()){
            return fetchArticles()
        }

        return articlesDb
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchArticles = service.fetchArticles()
        dataSource.insertArticles(fetchArticles)
        return fetchArticles
    }
}