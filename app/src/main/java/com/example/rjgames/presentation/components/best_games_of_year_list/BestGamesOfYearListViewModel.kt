package com.example.rjgames.presentation.components.best_games_of_year_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rjgames.data.Resource
import com.example.rjgames.domain.usecase.GamesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

@HiltViewModel
class BestGamesOfYearListViewModel @Inject constructor(
    private val gamesUseCases: GamesUseCases
) : ViewModel() {

    private val _state: MutableState<BestGamesOfYearState> =
        mutableStateOf(BestGamesOfYearState())
    val state: State<BestGamesOfYearState> = _state

    init {
        getGamesBestOfYear()
    }


    private fun getGamesBestOfYear(){
        val year = (Calendar.getInstance().get(Calendar.YEAR) - 1).toString()

        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO){
                    gamesUseCases.getGamesBestOfYear(year)
                }

                result.collect{
                    when(it){
                        is Resource.Success -> {
                            _state.value = BestGamesOfYearState(
                                isLoading = false,
                                games = it.data ?: listOf(),
                            )
                        }
                        is Resource.Error -> {
                            _state.value = BestGamesOfYearState(
                                error = it.message ?: "An unexpected error occurred",
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = BestGamesOfYearState(isLoading = true)
                        }
                    }
                }

            }catch (e: Exception){
                _state.value = BestGamesOfYearState(
                    error = e.message ?: "An unexpected error occurred",
                    isLoading = false
                )
            }
        }

        /*gamesUseCases.getGamesBestOfYear(year).onEach {resource ->
            when(resource){
                is Resource.Success -> {
                    _state.value = BestGamesOfYearState(
                        isLoading = false,
                        games = resource.data ?: listOf(),
                    )
                }
                is Resource.Error -> {
                    _state.value = BestGamesOfYearState(
                        error = resource.message ?: "An unexpected error occurred" ,
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    _state.value = BestGamesOfYearState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)*/
    }



}