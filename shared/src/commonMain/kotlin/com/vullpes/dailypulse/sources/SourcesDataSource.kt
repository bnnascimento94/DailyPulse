package com.vullpes.dailypulse.sources

import com.vullpes.dailypulse.db.DailyPulseDatabase

class SourcesDataSource(private val database: DailyPulseDatabase)  {

    fun getAllSources(): List<SourceRaw> = database.dailyPulseDatabaseQueries.selectAllSources(::mapToSourceRaw).executeAsList()

    fun insertSource(sources: List<SourceRaw>){
        database.dailyPulseDatabaseQueries.transaction {
            sources.forEach {sourceRaw ->
                insertSource(sourceRaw)

            }
        }
    }

    fun clearSources() = database.dailyPulseDatabaseQueries.removeAllSources()

    private fun insertSource(sourceRaw: SourceRaw) {
        database.dailyPulseDatabaseQueries.insertSource(
            sourceRaw.id,
            sourceRaw.name,
            sourceRaw.description,
            sourceRaw.language,
            sourceRaw.country
        )
    }

    private fun mapToSourceRaw(
        id:String,
        name: String,
        description:String,
        language:String,
        country:String
    ): SourceRaw = SourceRaw(
        id = id,
        name = name,
        description = description,
        language = language,
        country = country
    )
}