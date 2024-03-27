package com.example.kotlin62.data.remote.paging.sourse

import androidx.core.net.toUri
import com.example.kotlin62.ui.model.Data
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlin62.data.remote.apiservice.AnimeApiService
import okio.IOException

private const val START_KEY = 0

class AnimePagingSource(private val animeApi: AnimeApiService) :
    PagingSource<Int, Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {

        return try {
            val offset = params.key ?: START_KEY
            val response = animeApi.getAnime(offset = offset, params.loadSize)
            val nextKey = response.links.next.toUri().getQueryParameter("page[offset]")?.toInt()
            LoadResult.Page(
                data = response.data,
                nextKey = nextKey,
                prevKey = null
            )
        } catch (e: IOException) {
            LoadResult.Error(e)

        } catch (e: retrofit2.HttpException) {
            LoadResult.Error(e)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}