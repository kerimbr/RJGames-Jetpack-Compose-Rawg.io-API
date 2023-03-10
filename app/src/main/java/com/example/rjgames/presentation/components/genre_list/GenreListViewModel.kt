package com.example.rjgames.presentation.components.genre_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rjgames.data.Resource
import com.example.rjgames.domain.usecase.GenreUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GenreListViewModel @Inject constructor(
    private val genreUseCases: GenreUseCases
) : ViewModel() {

    private val _state: MutableState<GenreListState> = mutableStateOf(GenreListState())
    val state get() = _state as State<GenreListState>

    init {
        getGenreList()
    }

    private fun getGenreList() {

        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO){
                    genreUseCases.getAllCategories()
                }

                result.collect{
                    when (it) {
                        is Resource.Success -> {
                            _state.value = GenreListState(
                                isLoading = false,
                                genres = it.data ?: listOf(),
                            )
                        }

                        is Resource.Error -> {
                            _state.value = GenreListState(
                                error = it.message ?: "An unexpected error occurred",
                                isLoading = false
                            )
                        }

                        is Resource.Loading -> {
                            _state.value = GenreListState(isLoading = true)
                        }
                    }
                }

            } catch (e: Exception) {
                _state.value = GenreListState(
                    error = e.message ?: "An unexpected error occurred",
                    isLoading = false
                )
            }
        }

       /* genreUseCases.getAllCategories().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = GenreListState(
                        isLoading = false,
                        genres = resource.data ?: listOf(),
                    )
                }

                is Resource.Error -> {
                    _state.value = GenreListState(
                        error = resource.message ?: "An unexpected error occurred",
                        isLoading = false
                    )
                }

                is Resource.Loading -> {
                    _state.value = GenreListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)*/

    }
}