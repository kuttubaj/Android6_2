package com.example.kotlin62.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.kotlin62.data.remote.apiservice.AnimeApiService
import com.example.kotlin62.ui.model.Data
import com.example.kotlin62.data.remote.paging.sourse.AnimePagingSource
import javax.inject.Inject

class AnimeRepositories @Inject constructor(
    private val animeApi: AnimeApiService
) {

    fun fetchAnime(): LiveData<PagingData<Data>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { AnimePagingSource(animeApi) }
        ).liveData
    }
}