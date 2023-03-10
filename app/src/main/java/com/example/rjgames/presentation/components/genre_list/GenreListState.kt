package com.example.rjgames.presentation.components.genre_list

import com.example.rjgames.domain.model.Genre


data class GenreListState(
    val isLoading: Boolean = false,
    val error: String = "",
    val genres: List<Genre> = emptyList()
)
