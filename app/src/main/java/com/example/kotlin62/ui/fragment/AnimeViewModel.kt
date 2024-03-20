package com.example.kotlin62.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.kotlin62.data.repository.AnimeRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repositories: AnimeRepositories
) : ViewModel() {

    init {
        fetchAnime()
    }

    fun fetchAnime() = repositories.fetchAnime().cachedIn(viewModelScope)
}