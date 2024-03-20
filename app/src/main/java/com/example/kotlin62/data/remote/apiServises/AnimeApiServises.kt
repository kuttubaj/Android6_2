package com.example.kotlin62.data.remote.apiServises


import com.example.kotlin62.data.remote.models.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val END_POINT = "anime/"

interface AnimeApiServises {

    @GET(END_POINT)
    suspend fun getAnime(
        @Query("offset") offset: Int,
        @Query("limit") limit:Int
    ): AnimeResponse
}