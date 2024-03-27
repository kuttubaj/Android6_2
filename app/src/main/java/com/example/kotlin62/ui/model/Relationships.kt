package com.example.kotlin62.ui.model
import com.google.gson.annotations.SerializedName

data class Relationships(
    @SerializedName("castings")
    val castings: Castings,
    @SerializedName("mappings")
    val mappings: Mappings,
    @SerializedName("reviews")
    val reviews: Reviews,
    @SerializedName("installments")
    val installments: Installments,
    @SerializedName("chapters")
    val chapters: Chapters,
    @SerializedName("genres")
    val genres: Genres,
    @SerializedName("mangaStaff")
    val mangaStaff: AnimeStaff,
    @SerializedName("mediaRelationships")
    val mediaRelationships: MediaRelationships,
    @SerializedName("categories")
    val categories: Categories,
    @SerializedName("mangaCharacters")
    val mangaCharacters: AnimeCharacters
)