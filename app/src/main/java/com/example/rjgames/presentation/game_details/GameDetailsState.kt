package com.example.rjgames.presentation.game_details

import com.example.rjgames.domain.model.GameDetails


data class GameDetailsState(
    val isLoading: Boolean = false,
    val gameDetails: GameDetails? = null,
    val error: String? = null,
    val isFavorite: Boolean = false
)
