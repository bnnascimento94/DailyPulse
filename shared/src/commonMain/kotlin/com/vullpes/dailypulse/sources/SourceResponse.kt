package com.vullpes.dailypulse.sources

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourceResponse(
    @SerialName("status")
    val status: String,
    @SerialName("sources")
    val sources: List<SourceRaw>

)