package com.example.rjgames.presentation.discover

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rjgames.domain.model.Game
import com.example.rjgames.domain.usecase.GamesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val gamesUseCases: GamesUseCases
) : ViewModel() {

    private val _state: MutableState<DiscoverState> = mutableStateOf(DiscoverState())
    val state: State<DiscoverState> = _state

    val lazyListState: LazyListState = LazyListState()

    init {
        _state.value = _state.value.copy(
            bestOfAllTimeGames = getBestOfAllTimeWithPagination()
        )
    }

    private fun getBestOfAllTimeWithPagination(): Flow<PagingData<Game>> {
        return gamesUseCases.getBestOfAllTimeWithPagination()
            .cachedIn(viewModelScope)
    }

}