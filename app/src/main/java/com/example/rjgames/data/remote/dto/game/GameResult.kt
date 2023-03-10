package com.example.rjgames.data.remote.dto.game


import com.example.rjgames.data.remote.dto.game.*
import com.google.gson.annotations.SerializedName

data class GameResult(
    @SerializedName("added")
    val added: Int?,
    @SerializedName("added_by_status")
    val addedByStatus: GameAddedByStatus?,
    @SerializedName("background_image")
    val backgroundImage: String?,
    @SerializedName("clip")
    val clip: Any?,
    @SerializedName("dominant_color")
    val dominantColor: String?,
    @SerializedName("esrb_rating")
    val esrbRating: Any?,
    @SerializedName("genres")
    val genres: List<GameGenre>?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("metacritic")
    val metacritic: Int?,
    @SerializedName("name")
    val name: String,
    @SerializedName("parent_platforms")
    val parentPlatforms: List<GameParentPlatform>?,
    @SerializedName("platforms")
    val platforms: List<GamePlatformX>?,
    @SerializedName("playtime")
    val playtime: Int?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("rating_top")
    val ratingTop: Int?,
    @SerializedName("ratings")
    val ratings: List<GameRating>?,
    @SerializedName("ratings_count")
    val ratingsCount: Int?,
    @SerializedName("released")
    val released: String?,
    @SerializedName("reviews_count")
    val reviewsCount: Int?,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int?,
    @SerializedName("saturated_color")
    val saturatedColor: String?,
    @SerializedName("score")
    val score: String?,
    @SerializedName("short_screenshots")
    val shortScreenshots: List<GameShortScreenshot>?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("stores")
    val stores: List<GameStore>?,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int?,
    @SerializedName("tags")
    val tags: List<GameTag>?,
    @SerializedName("tba")
    val tba: Boolean?,
    @SerializedName("updated")
    val updated: String?,
    @SerializedName("user_game")
    val userGame: Any?
)