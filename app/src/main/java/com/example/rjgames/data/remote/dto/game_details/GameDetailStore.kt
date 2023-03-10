package com.example.rjgames.data.remote.dto.game_details


import com.google.gson.annotations.SerializedName

data class GameDetailStore(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("store")
    val store: GameDetailStoreX?,
    @SerializedName("url")
    val url: String?
)