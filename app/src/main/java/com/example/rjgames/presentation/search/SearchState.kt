package com.example.rjgames.presentation.search

import com.example.rjgames.domain.model.Game


data class SearchState(

    val isLoading: Boolean = false,
    val isSearched: Boolean = false,
    val error: String? = null,
    val searchResults: List<Game> = emptyList()

)
