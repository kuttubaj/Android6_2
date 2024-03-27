package com.example.kotlin62.data.remote.apiservice

import com.example.kotlin62.ui.model.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val END_POINT = "edge/anime"

interface AnimeApiService {

    @GET(END_POINT)
    suspend fun getAnime(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int
    ): AnimeResponse
}