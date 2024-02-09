package com.vullpes.dailypulse.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.BodyProgress
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import io.ktor.client.plugins.BodyProgress.Plugin.install
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module{
    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }


    }
}