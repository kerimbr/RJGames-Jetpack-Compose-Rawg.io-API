package com.example.rjgames.domain.model

import com.example.rjgames.data.remote.dto.game.*


data class Game(
    val id: Int,
    val name: String,
    val slug: String? = null,
    val playTime: Int? = null,
    val platforms: List<GamePlatform>? = null,
    val stores: List<GameStoreX>? = null,
    val released: String? = null,
    val tba: Boolean? = null,
    val backgroundImage: String? = null,
    val rating: Double? = null,
    val ratingTop: Int? = null,
    val ratings: List<GameRating>? = null,
    val ratingsCount: Int? = null,
    val added: Int? = null,
    val addedByStatus: GameAddedByStatus? = null,
    val metacritic: Int? = null,
    val suggestionsCount: Int? = null,
    val updated: String? = null,
    val score: String? = null,
    val tags: List<GameTag>? = null,
    val parrentPlatform: List<GamePlatform>? = null,
    val genres: List<GameGenre>? = null,
)