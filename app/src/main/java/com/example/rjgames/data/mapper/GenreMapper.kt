package com.example.rjgames.data.mapper

import com.example.rjgames.data.remote.dto.game_details.GameDetailGenre
import com.example.rjgames.data.remote.dto.genre.GenreResult
import com.example.rjgames.data.remote.dto.genre.GenresResponse
import com.example.rjgames.domain.model.Genre


fun GenreResult.toGenre(): Genre = Genre(
    gamesCount = gamesCount,
    id = id,
    imageBackground = imageBackground,
    name = name,
    slug = slug
)

fun GameDetailGenre.toGenre(): Genre = Genre(
    gamesCount = gamesCount,
    id = id,
    imageBackground = imageBackground,
    name = name?:"",
    slug = slug
)


fun GenresResponse.toGenreList(): List<Genre> {
    return genreResults.map {
        it.toGenre()
    }
}