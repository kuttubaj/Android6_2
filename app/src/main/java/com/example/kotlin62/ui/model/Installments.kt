package com.example.kotlin62.ui.model
import com.google.gson.annotations.SerializedName

data class Installments(
    @SerializedName("links")
    val links: Links
)