package com.example.rjgames.data.remote.dto.genre


import com.google.gson.annotations.SerializedName

data class GenresResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val genreResults: List<GenreResult>
)