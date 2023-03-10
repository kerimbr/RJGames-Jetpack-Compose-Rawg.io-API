package com.example.rjgames.data.remote.dto.game_screenshots


import com.google.gson.annotations.SerializedName

data class GameScreenShotsResult(
    @SerializedName("height")
    val height: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("is_deleted")
    val isDeleted: Boolean?,
    @SerializedName("width")
    val width: Int?
)