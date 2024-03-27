package com.example.kotlin62.ui.model
import com.google.gson.annotations.SerializedName

data class Tiny(
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("height")
    val height: Int? = null
)