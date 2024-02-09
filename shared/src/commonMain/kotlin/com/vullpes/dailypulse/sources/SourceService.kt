package com.vullpes.dailypulse.sources

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourceService(private val httpClient: HttpClient) {
    private val apiKey = "811a6496ee5f482c85c4b51c55da6c5d"

    suspend fun fetchSources():List<SourceRaw>{
        val response: SourceResponse = httpClient.get("https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey").body()
        return response.sources
    }
}