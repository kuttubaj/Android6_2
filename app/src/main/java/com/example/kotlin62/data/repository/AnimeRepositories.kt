package com.example.kotlin62.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.kotlin62.data.remote.apiServises.AnimeApiServises
import com.example.kotlin62.data.remote.models.Data
import com.example.kotlin62.data.remote.paging.sourse.AnimePagingSource
import javax.inject.Inject

class AnimeRepositories @Inject constructor(
    private val animeApi: AnimeApiServises
) {

    fun fetchAnime(): LiveData<PagingData<Data>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 40,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { AnimePagingSource(animeApi) }
        ).liveData
    }
}