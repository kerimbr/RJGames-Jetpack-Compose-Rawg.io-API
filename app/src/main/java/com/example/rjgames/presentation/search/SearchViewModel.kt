package com.example.rjgames.presentation.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rjgames.data.Resource
import com.example.rjgames.domain.usecase.GamesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val gamesUseCases: GamesUseCases
) : ViewModel() {

    private val _state: MutableState<SearchState> = mutableStateOf(SearchState())
    val state: State<SearchState> get() = _state

    fun getResult(query: String) {
        _state.value = _state.value.copy(isSearched = true)

        gamesUseCases.getSearchResults(query).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        searchResults = resource.data ?: listOf()
                    )
                }

                is Resource.Error -> {
                    _state.value = SearchState(
                        error = resource.message ?: "An unexpected error occurred",
                        isLoading = false
                    )
                }

                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}