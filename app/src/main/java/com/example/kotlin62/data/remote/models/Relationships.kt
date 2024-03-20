package com.example.kotlin62.data.remote.models

data class Relationships(
    val animeCharacters: AnimeCharacters,
    val animeProductions: AnimeProductions,
    val animeStaff: AnimeStaff,
    val castings: Castings,
    val categories: Categories,
    val episodes: Episodes,
    val genres: Genres,
    val installments: Installments,
    val mappings: Mappings,
    val mediaRelationships: MediaRelationships,
    val reviews: Reviews,
    val streamingLinks: StreamingLinks
)