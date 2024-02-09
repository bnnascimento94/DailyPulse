package com.vullpes.dailypulse.sources


class ListSourceUsecase(private val repo: SourceRepository) {

    suspend fun invoke(): List<Source> {
        val articlesRaw = repo.getSources()
        return mapSources(articlesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourceRaw>): List<Source> {
        return sourcesRaw.map { raw ->
            Source(
                raw.id,
                raw.name,
                raw.description,
                raw.language,
                raw.country
            )
        }
    }
}