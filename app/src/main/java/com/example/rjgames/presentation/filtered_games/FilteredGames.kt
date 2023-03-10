package com.example.rjgames.presentation.filtered_games

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.rjgames.domain.model.GameQueries
import com.example.rjgames.presentation.components.vertical_game_list.verticalGameListWithoutPagination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilteredGames(
    navController: NavController,
    gameQueries: GameQueries,
    viewModel: FilteredGamesViewModel = hiltViewModel()
) {

    val scrollState = rememberLazyListState()

    LaunchedEffect(gameQueries){
        viewModel.getGames(gameQueries)
    }

    if (viewModel.state.value.isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }else{
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(text = "Filtered Games") }
                )
            }
        ) { paddingValues ->

            if (viewModel.state.value.games.isNullOrEmpty()){
                Box(modifier = Modifier.fillMaxSize()){
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "No games found"
                    )
                }
            }else{
                LazyColumn(state = scrollState, contentPadding = paddingValues){
                    verticalGameListWithoutPagination(
                        modifier = Modifier,
                        navController = navController,
                        list = viewModel.state.value.games ?: emptyList()
                    )
                }
            }


        }
    }


}