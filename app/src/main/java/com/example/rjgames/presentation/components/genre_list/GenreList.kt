package com.example.rjgames.presentation.components.genre_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.rjgames.domain.model.GameQueries
import com.example.rjgames.domain.model.toJSON
import com.example.rjgames.presentation.raw_jet_game_app.Screens

@Composable
fun GenreList(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: GenreListViewModel = hiltViewModel(),
) {


    if (viewModel.state.value.isLoading) {
        Box(modifier = modifier) {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(6) {
                    GenreListItemShimmer()
                }
            }
        }
    } else {
        Box(modifier = modifier) {

            LazyRow(
                state = rememberLazyListState()
            ) {
                items(viewModel.state.value.genres.size) { index ->
                    val genre = viewModel.state.value.genres[index]
                    GenreListItem(
                        genre = genre,
                        onItemClicked = {
                            val gameQueries = GameQueries(genres = genre.id.toString())
                            val route = Screens.FilteredGamesScreen.route + "/${gameQueries.toJSON()}"
                            navController.navigate(route)
                        }
                    )
                }
            }
        }
    }
}
