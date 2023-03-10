package com.example.rjgames.domain.model

import com.google.gson.Gson

data class GameQueries(
    val page: Int? = null,
    val pageSize: Int? = null,
    val search: String? = null,
    val parentPlatforms: String? = null,
    val genres: String? = null,
    val platforms: String? = null,
    val stores: String? = null,
    val developers: String? = null,
    val publishers: String? = null,
    val tags: String? = null,
    val dates: String? = null,
    val ordering: String? = null,
)

fun GameQueries.toJSON(): String {
    return Gson().toJson(this)
}

fun String.toGameQueries(): GameQueries {
    return Gson().fromJson(this, GameQueries::class.java)
}