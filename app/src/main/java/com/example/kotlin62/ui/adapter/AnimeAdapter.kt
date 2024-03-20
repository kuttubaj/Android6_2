package com.example.kotlin62.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin62.ui.model.AnimeData
import com.example.kotlin62.databinding.ItemAnimeBinding

class AnimeAdapter : PagingDataAdapter<AnimeData, AnimeAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(animeData: AnimeData) = with(binding) {
            Glide.with(ivItemAnime.context)
                .load("https://media.kitsu.io/anime/poster_images/1/${animeData.id}original.jpg")
                .into(ivItemAnime)
            tvItemAnime.text = animeData.links.replaceFirstChar { it.uppercase() }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun submitData(pagingData: PagingData<Data>?) {

    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<AnimeData>() {
            override fun areItemsTheSame(oldItem: AnimeData, newItem: AnimeData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: AnimeData, newItem: AnimeData): Boolean {
                return oldItem == newItem
            }
        }
    }
}