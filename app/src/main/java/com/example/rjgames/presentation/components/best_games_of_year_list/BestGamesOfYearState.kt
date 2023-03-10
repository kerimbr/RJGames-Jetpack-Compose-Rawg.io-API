package com.example.rjgames.presentation.components.best_games_of_year_list

import com.example.rjgames.domain.model.Game


data class BestGamesOfYearState(
    val isLoading: Boolean = false,
    val error: String = "",
    val games: List<Game> = emptyList()
)