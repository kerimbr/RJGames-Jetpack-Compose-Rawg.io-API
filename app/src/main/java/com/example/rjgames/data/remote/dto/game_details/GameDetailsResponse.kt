package com.example.rjgames.data.remote.dto.game_details


import com.example.rjgames.data.remote.dto.game_details.*
import com.google.gson.annotations.SerializedName

data class GameDetailsResponse(
    @SerializedName("achievements_count")
    val achievementsCount: Int?,
    @SerializedName("added")
    val added: Int?,
    @SerializedName("added_by_status")
    val addedByStatus: GameDetailAddedByStatus?,
    @SerializedName("additions_count")
    val additionsCount: Int?,
    @SerializedName("alternative_names")
    val alternativeNames: List<String>?,
    @SerializedName("background_image")
    val backgroundImage: String?,
    @SerializedName("background_image_additional")
    val backgroundImageAdditional: String?,
    @SerializedName("clip")
    val clip: Any?,
    @SerializedName("creators_count")
    val creatorsCount: Int?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("description_raw")
    val descriptionRaw: String?,
    @SerializedName("developers")
    val developers: List<GameDetailDeveloper>?,
    @SerializedName("dominant_color")
    val dominantColor: String?,
    @SerializedName("esrb_rating")
    val esrbRating: Any?,
    @SerializedName("game_series_count")
    val gameSeriesCount: Int?,
    @SerializedName("genres")
    val genres: List<GameDetailGenre>?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("metacritic")
    val metacritic: Any?,
    @SerializedName("metacritic_platforms")
    val metacriticPlatforms: List<Any>?,
    @SerializedName("metacritic_url")
    val metacriticUrl: String?,
    @SerializedName("movies_count")
    val moviesCount: Int?,
    @SerializedName("name")
    val name: String,
    @SerializedName("name_original")
    val nameOriginal: String?,
    @SerializedName("parent_achievements_count")
    val parentAchievementsCount: Int?,
    @SerializedName("parent_platforms")
    val parentPlatforms: List<GameDetailParentPlatform>?,
    @SerializedName("parents_count")
    val parentsCount: Int?,
    @SerializedName("platforms")
    val platforms: List<GameDetailPlatformX>?,
    @SerializedName("playtime")
    val playtime: Int?,
    @SerializedName("publishers")
    val publishers: List<GameDetailPublisher>?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("rating_top")
    val ratingTop: Int?,
    @SerializedName("ratings")
    val ratings: List<GameDetailRating>?,
    @SerializedName("ratings_count")
    val ratingsCount: Int?,
    @SerializedName("reactions")
    val reactions: GameDetailReactions?,
    @SerializedName("reddit_count")
    val redditCount: Int?,
    @SerializedName("reddit_description")
    val redditDescription: String?,
    @SerializedName("reddit_logo")
    val redditLogo: String?,
    @SerializedName("reddit_name")
    val redditName: String?,
    @SerializedName("reddit_url")
    val redditUrl: String?,
    @SerializedName("released")
    val released: Any?,
    @SerializedName("reviews_count")
    val reviewsCount: Int?,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int?,
    @SerializedName("saturated_color")
    val saturatedColor: String?,
    @SerializedName("screenshots_count")
    val screenshotsCount: Int?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("stores")
    val stores: List<GameDetailStore>?,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int?,
    @SerializedName("tags")
    val tags: List<GameDetailTag>?,
    @SerializedName("tba")
    val tba: Boolean?,
    @SerializedName("twitch_count")
    val twitchCount: Int?,
    @SerializedName("updated")
    val updated: String?,
    @SerializedName("user_game")
    val userGame: Any?,
    @SerializedName("website")
    val website: String?,
    @SerializedName("youtube_count")
    val youtubeCount: Int?
)