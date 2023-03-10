package com.example.rjgames.presentation.game_details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rjgames.data.Resource
import com.example.rjgames.domain.model.GameDetails
import com.example.rjgames.domain.usecase.FavoriteUseCases
import com.example.rjgames.domain.usecase.GamesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GameDetailsViewModel @Inject constructor(
    private val gamesUseCases: GamesUseCases,
    private val favoriteUseCases: FavoriteUseCases
) : ViewModel() {

    private val _state: MutableState<GameDetailsState> = mutableStateOf(GameDetailsState())
    val state: State<GameDetailsState> = _state


    fun isFavorite(gameId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = favoriteUseCases.isFavorite(id = gameId)
            _state.value = _state.value.copy(isFavorite = result)
        }
    }


    fun addToFavorites(gameDetail: GameDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteUseCases.addFavorite(gameDetail)
            _state.value = _state.value.copy(isFavorite = true)
        }
    }

    fun removeFromFavorites(gameDetail: GameDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteUseCases.removeFavorite(gameDetail)
            _state.value = _state.value.copy(isFavorite = false)
        }
    }


    fun getGameDetails(gameId: Int) {

        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    gamesUseCases.getGameDetails(id = gameId)
                }

                result.collect{
                    when (it) {
                        is Resource.Success -> {
                            _state.value = _state.value.copy(
                                isLoading = false,
                                gameDetails = it.data
                            )
                        }

                        is Resource.Error -> {
                            _state.value = GameDetailsState(
                                error = it.message ?: "An unexpected error occurred",
                                isLoading = false
                            )
                        }

                        is Resource.Loading -> {
                            _state.value = _state.value.copy(isLoading = true)
                        }
                    }

                }

            } catch (e: Exception) {
                _state.value = GameDetailsState(
                    error = e.message ?: "An unexpected error occurred",
                    isLoading = false
                )
            }
        }

        /*
                gamesUseCases.getGameDetails(id = gameId).onEach{
                    when (it) {
                        is Resource.Success -> {
                            _state.value = _state.value.copy(
                                isLoading = false,
                                gameDetails = it.data
                            )
                        }

                        is Resource.Error -> {
                            _state.value = GameDetailsState(
                                error = it.message ?: "An unexpected error occurred",
                                isLoading = false
                            )
                        }

                        is Resource.Loading -> {
                            _state.value = _state.value.copy(isLoading = true)
                        }
                    }
                }.launchIn(viewModelScope)
        */
    }

}
