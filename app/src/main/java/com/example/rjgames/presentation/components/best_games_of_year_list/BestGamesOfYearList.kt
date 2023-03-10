package com.example.rjgames.presentation.components.best_games_of_year_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.rjgames.presentation.raw_jet_game_app.Screens

@Composable
fun BestGameOfYearList(
    modifier: Modifier = Modifier,
    viewModel: BestGamesOfYearListViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state: BestGamesOfYearState = viewModel.state.value

    val listState: LazyListState = rememberLazyListState()

    if (state.isLoading) {
        Box(modifier = modifier) {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                state = listState
            ) {
                items(6) {
                    BestGamesOfYearListItemShimmer()
                }
            }
        }
    } else {
        Box(modifier = modifier) {
            LazyRow() {
                items(state.games.size) { index ->
                    val game = state.games[index]
                    BestGamesOfYearListItem(
                        game = game,
                        onItemClicked = {
                            navController.navigate(Screens.GameDetailsScreen.route + "/${game.id}")
                        }
                    )
                }
            }
        }
    }

}