package com.example.rjgames.presentation.filtered_games

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rjgames.data.Resource
import com.example.rjgames.domain.model.GameQueries
import com.example.rjgames.domain.usecase.GamesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FilteredGamesViewModel @Inject constructor(
    private val gamesUseCases: GamesUseCases
) : ViewModel() {

    private val _state: MutableState<FilteredGamesState> = mutableStateOf(FilteredGamesState())
    val state: State<FilteredGamesState> = _state

    fun getGames(gameQueries: GameQueries){

        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO){
                    gamesUseCases.getGamesWithQueries(gameQueries)
                }

                result.collect{
                    when(it){
                        is Resource.Success -> {
                            _state.value = FilteredGamesState(
                                isLoading = false,
                                games = it.data ?: listOf(),
                            )
                        }
                        is Resource.Error -> {
                            _state.value = FilteredGamesState(
                                error = it.message ?: "An unexpected error occurred",
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = FilteredGamesState(isLoading = true)
                        }
                    }
                }

            }catch (e: Exception){
                _state.value = FilteredGamesState(
                    error = e.message ?: "An unexpected error occurred",
                    isLoading = false
                )

            }
        }

        /*gamesUseCases.getGamesWithQueries(gameQueries).onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _state.value = FilteredGamesState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FilteredGamesState(games = resource.data)
                }
                is Resource.Error -> {
                    _state.value = FilteredGamesState(error = resource.message)
                }
            }
        }.launchIn(viewModelScope)*/

    }

}