package com.example.rjgames.data.remote.dto.game_details


import com.google.gson.annotations.SerializedName

data class GameDetailRequirements(
    @SerializedName("minimum")
    val minimum: String?
)