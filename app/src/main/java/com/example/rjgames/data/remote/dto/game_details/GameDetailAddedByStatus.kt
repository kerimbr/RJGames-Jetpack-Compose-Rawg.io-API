package com.example.rjgames.data.remote.dto.game_details


import com.google.gson.annotations.SerializedName

data class GameDetailAddedByStatus(
    @SerializedName("beaten")
    val beaten: Int?,
    @SerializedName("dropped")
    val dropped: Int?,
    @SerializedName("owned")
    val owned: Int?,
    @SerializedName("playing")
    val playing: Int?,
    @SerializedName("toplay")
    val toplay: Int?,
    @SerializedName("yet")
    val yet: Int?
)