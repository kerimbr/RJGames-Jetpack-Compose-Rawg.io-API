package com.example.rjgames.data.remote.dto.game_details


import com.google.gson.annotations.SerializedName

data class GameDetailRating(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("percent")
    val percent: Double?,
    @SerializedName("title")
    val title: String?
)