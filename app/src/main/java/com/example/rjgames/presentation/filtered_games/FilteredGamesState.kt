package com.example.rjgames.presentation.filtered_games

import com.example.rjgames.domain.model.Game


data class FilteredGamesState(
    val isLoading: Boolean = false,
    val games: List<Game>? = emptyList(),
    val error: String? = null,
)
