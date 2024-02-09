package com.vullpes.dailypulse.articles.data

import com.vullpes.dailypulse.articles.data.ArticleRaw
import com.vullpes.dailypulse.articles.data.ArticleResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "811a6496ee5f482c85c4b51c55da6c5d"

    suspend fun fetchArticles():List<ArticleRaw>{
        val response: ArticleResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles
    }
}