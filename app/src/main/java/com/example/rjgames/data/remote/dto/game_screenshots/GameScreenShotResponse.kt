package com.example.rjgames.data.remote.dto.game_screenshots


import com.google.gson.annotations.SerializedName

data class GameScreenShotResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<GameScreenShotsResult?>?
)