package com.example.rjgames.data.remote.dto.game_details


import com.google.gson.annotations.SerializedName

data class GameDetailPlatformX(
    @SerializedName("platform")
    val platform: GameDetailPlatformXX?,
    @SerializedName("released_at")
    val releasedAt: Any?,
    @SerializedName("requirements")
    val requirements: GameDetailRequirements?
)