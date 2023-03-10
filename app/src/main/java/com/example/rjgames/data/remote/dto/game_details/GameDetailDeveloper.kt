package com.example.rjgames.data.remote.dto.game_details


import com.google.gson.annotations.SerializedName

data class GameDetailDeveloper(
    @SerializedName("games_count")
    val gamesCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_background")
    val imageBackground: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)