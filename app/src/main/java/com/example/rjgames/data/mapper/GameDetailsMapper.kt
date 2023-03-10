package com.example.rjgames.data.mapper

import com.example.rjgames.data.remote.dto.game.GameGenre
import com.example.rjgames.data.remote.dto.game_details.GameDetailGenre
import com.example.rjgames.data.remote.dto.game_details.GameDetailsResponse
import com.example.rjgames.domain.model.GameDetails


fun GameDetailsResponse.toGameDetails(): GameDetails = GameDetails(
    id = id,
    name = name,
    released = released?.toString(),
    backgroundImage = backgroundImage,
    description = description,
    descriptionRaw = descriptionRaw,
    rating = rating,
    ratingsCount = ratingsCount,
    ratingTop = ratingTop,
    playtime = playtime,
    ratings = ratings,
    genres = genres,
    developers = developers,
    tags = tags,
    metacritic = metacritic?.toString(),
    added = added,
    parrentPlatforms = parentPlatforms?.map { it.platform?.name },
    platforms = platforms?.map { it.platform?.name },
    stores = stores?.map { it.store },
    publisher = publishers,
    website = website,
    screenshots = null
)

fun GameDetailGenre.toGameGenre(): GameGenre{
    return GameGenre(
        id = id ?: 0,
        name = name ?: "",
        slug = slug ?: "",
    )
}