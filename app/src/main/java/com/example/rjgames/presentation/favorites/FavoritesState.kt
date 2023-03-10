package com.example.rjgames.presentation.favorites

import com.example.rjgames.domain.model.GameDetails

data class FavoritesState(
    val isLoading: Boolean = false,
    val favorites: List<GameDetails> = emptyList(),
    val error: String = "",
)
