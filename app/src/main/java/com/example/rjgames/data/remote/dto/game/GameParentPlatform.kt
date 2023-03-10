package com.example.rjgames.data.remote.dto.game


import com.google.gson.annotations.SerializedName

data class GameParentPlatform(
    @SerializedName("platform")
    val platform: GamePlatform
)