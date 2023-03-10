package com.example.rjgames.presentation.favorites

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rjgames.domain.usecase.FavoriteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoriteUseCases: FavoriteUseCases
) : ViewModel() {

    private val _state: MutableState<FavoritesState> = mutableStateOf(FavoritesState())
    val state: State<FavoritesState> = _state


    init {
        getAllFavorites()
    }

    private fun getAllFavorites() {
        viewModelScope.launch {
            try {
                _state.value = FavoritesState(isLoading = true)
                val result = withContext(Dispatchers.IO) {
                    favoriteUseCases.getAllFavorites()
                }
                result.collect {
                    _state.value = FavoritesState(favorites = it)
                }
            } catch (e: Exception) {
                _state.value = FavoritesState(error = e.message ?: "Unknown error")
            }

        }
    }


}