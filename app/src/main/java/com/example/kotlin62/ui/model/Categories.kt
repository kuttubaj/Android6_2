package com.example.kotlin62.ui.model

import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("links")
    val links: Links
)