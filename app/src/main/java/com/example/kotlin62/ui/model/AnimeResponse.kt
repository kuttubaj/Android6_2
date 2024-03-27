package com.example.kotlin62.ui.model
import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("links")
    val links: Links,
    @SerializedName("data")
    val data: List<Data>
)