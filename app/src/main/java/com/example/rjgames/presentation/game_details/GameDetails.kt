package com.example.rjgames.presentation.game_details

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rjgames.domain.model.GameQueries
import com.example.rjgames.domain.model.toJSON
import com.example.rjgames.presentation.game_details.components.*
import com.example.rjgames.presentation.raw_jet_game_app.Screens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailsPage(
    navController: NavController = rememberNavController(),
    gameId: Int,
    viewModel: GameDetailsViewModel = hiltViewModel(),
) {

    val scrollState: ScrollState = rememberScrollState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(gameId) {
        viewModel.getGameDetails(gameId = gameId)
        viewModel.isFavorite(gameId = gameId)
    }

    if (viewModel.state.value.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else {
        val game = remember{ viewModel.state.value.gameDetails }

        if (game == null) {
            Text(text = "No game found")
        } else {
            Scaffold(
                snackbarHost = { SnackbarHost(snackbarHostState) },
                topBar = {
                    GameDetailsTopBar(
                        navController = navController,
                        isFavorite = viewModel.state.value.isFavorite,
                        onChangeFavorite = { value ->
                            if (value) {
                                viewModel.addToFavorites(game)
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Added to favorites",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            } else {
                                viewModel.removeFromFavorites(game)
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Removed from favorites",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            }
                        }
                    )
                },
                containerColor = MaterialTheme.colorScheme.tertiaryContainer
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    GameDetailsHeader(game = game)

                    GameDetailsSectionHeader(
                        modifier = Modifier.padding(top = 16.dp),
                        title = "Description"
                    )
                    Text(
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                        text = game.descriptionRaw ?: "No description",
                    )


                    GameDetailsSectionHeader(
                        title = "Genres",
                        modifier = Modifier.padding(top = 16.dp),
                    )
                    GameDetailGenres(
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                        genres = game.genres,
                        onItemClick = {
                            val gameQueries = GameQueries(genres = it)
                            val route =
                                Screens.FilteredGamesScreen.route + "/${gameQueries.toJSON()}"
                            navController.navigate(route)
                        }
                    )

                    GameDetailsSectionHeader(
                        title = "Rating",
                        modifier = Modifier.padding(top = 16.dp),
                    )

                    GameDetailsRatingBar(
                        modifier = Modifier.padding(
                            top = 16.dp
                        ),
                        game = game
                    )

                    GameDetailsSectionHeader(
                        title = "Developers",
                        modifier = Modifier.padding(top = 16.dp),
                    )

                    if (game.developers.isNullOrEmpty()) {
                        Text(
                            modifier = Modifier.padding(
                                horizontal = 16.dp,
                                vertical = 8.dp
                            ),
                            text = "No developers found",
                        )
                    } else {
                        GameDetailDevelopers(developers = game.developers)
                    }

                    GameDetailsSectionHeader(
                        title = "Publishers",
                        modifier = Modifier.padding(top = 16.dp),
                    )

                    if (game.publisher.isNullOrEmpty()) {
                        Text(
                            modifier = Modifier.padding(
                                horizontal = 16.dp,
                                vertical = 8.dp
                            ),
                            text = "No publishers found",
                        )
                    } else {
                        GameDetailPublishers(publishers = game.publisher)
                    }

                    GameDetailsSectionHeader(
                        title = "Tags",
                        modifier = Modifier.padding(top = 16.dp),
                    )

                    if (game.tags.isNullOrEmpty()) {
                        Text(
                            modifier = Modifier.padding(
                                horizontal = 16.dp,
                                vertical = 8.dp
                            ),
                            text = "No tags found",
                        )
                    } else {
                        GameDetailTags(tags = game.tags)
                    }

                }
            }
        }
    }


}
