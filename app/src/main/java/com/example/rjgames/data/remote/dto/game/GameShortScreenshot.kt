package com.example.rjgames.data.remote.dto.game


import com.google.gson.annotations.SerializedName

data class GameShortScreenshot(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String
)