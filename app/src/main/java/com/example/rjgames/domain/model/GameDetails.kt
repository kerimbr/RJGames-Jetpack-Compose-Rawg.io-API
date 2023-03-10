package com.example.rjgames.domain.model

import androidx.room.Entity
import com.example.rjgames.data.remote.dto.game_details.*


@Entity(
    tableName = "favorites",
    primaryKeys = ["id"],
)
data class GameDetails(
    val id: Int,
    val name: String,
    val released: String?,
    val backgroundImage: String?,
    val description: String?,
    val descriptionRaw: String?,
    val rating: Double?,
    val ratingsCount: Int?,
    val ratingTop: Int?,
    val playtime: Int?,
    val ratings: List<GameDetailRating?>?,
    val genres: List<GameDetailGenre?>?,
    val developers: List<GameDetailDeveloper?>?,
    val tags: List<GameDetailTag>?,
    val metacritic: String?,
    val added: Int?,
    val parrentPlatforms: List<String?>?,
    val platforms: List<String?>?,
    val stores: List<GameDetailStoreX?>?,
    val publisher: List<GameDetailPublisher?>?,
    val website: String?,
    val screenshots: List<String?>?

)
