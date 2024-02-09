package com.vullpes.dailypulse.articles.data

import com.vullpes.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase) {

    fun getAllArticles(): List<ArticleRaw> = database.dailyPulseDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>){
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach {articleRaw ->
                insertArticle(articleRaw)

            }
        }
    }

    fun clearArticles() = database.dailyPulseDatabaseQueries.removeAllArticles()

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.dailyPulseDatabaseQueries.insertArticle(
            articleRaw.title,
            articleRaw.description,
            articleRaw.date,
            articleRaw.imageUrl
        )
    }

    private fun mapToArticleRaw(
        title:String,
        description: String?,
        date:String,
        url:String?
    ): ArticleRaw = ArticleRaw(
        title = title,
        description = description,
        date = date,
        imageUrl = url
    )

}