package com.example.rjgames.data.mapper

import com.example.rjgames.data.remote.dto.game.GameResult
import com.example.rjgames.data.remote.dto.game.GamesResponse
import com.example.rjgames.domain.model.Game
import com.example.rjgames.domain.model.GameDetails


fun GameResult.toGame(): Game {
    return Game(
        id = id,
        name = name,
        slug = slug,
        playTime = playtime,
        platforms = platforms?.map { it.platform },
        stores = stores?.map { it.store },
        released = released,
        tba = tba,
        backgroundImage = backgroundImage,
        rating = rating,
        ratingTop = ratingTop,
        ratings = ratings,
        ratingsCount = ratingsCount,
        added = added,
        addedByStatus = addedByStatus,
        //metacritic = metacritic,
        suggestionsCount = suggestionsCount,
        updated = updated,
        score = score,
        tags = tags,
        parrentPlatform = parentPlatforms?.map { it.platform },
        genres = genres
    )
}

fun GamesResponse.toGameList(): List<Game>{
    return results.map { it.toGame() }
}

fun GameDetails.toGame(): Game{
    return Game(
        id = id,
        name = name,
        released = released,
        backgroundImage = backgroundImage,
        rating = rating,
        ratingTop = ratingTop,
        ratingsCount = ratingsCount,
        genres = genres?.map { it!!.toGameGenre() },
        
    )
}