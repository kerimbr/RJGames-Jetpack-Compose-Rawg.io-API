package com.example.rjgames.presentation.favorites

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.rjgames.R
import com.example.rjgames.data.mapper.toGame
import com.example.rjgames.presentation.components.CustomTopBar
import com.example.rjgames.presentation.components.MainBottomBar
import com.example.rjgames.presentation.components.vertical_game_list.VerticalGameListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Favorites(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: FavoritesViewModel = hiltViewModel()
) {

    val listState = rememberLazyListState()

    Scaffold(
        topBar = { CustomTopBar(subtitle = "My Library") },
        bottomBar = { MainBottomBar(navController) }
    ) { paddingValues ->

        if (viewModel.state.value.isLoading) {
            Box(modifier = modifier.padding(paddingValues)) {
                Text(text = "Loading...")
            }
        }else{

            if (viewModel.state.value.favorites.isEmpty()) {
                Column(
                    modifier = modifier.padding(paddingValues).fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val composition by rememberLottieComposition(
                        LottieCompositionSpec.RawRes(R.raw.favorites)
                    )

                    LottieAnimation(
                        modifier = Modifier.size(120.dp),
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                    )

                    Text(
                        text = "Favorites is Empty",
                        modifier = Modifier.padding(top = 16.dp),
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = MaterialTheme.colorScheme.secondary.copy(
                                alpha = 0.8f
                            ),
                            fontWeight = FontWeight.Bold
                        )
                    )

                }
            }else{
                LazyColumn(
                    state = listState,
                    modifier = modifier.padding(paddingValues).fillMaxSize()) {
                    items(viewModel.state.value.favorites.size){
                        VerticalGameListItem(
                            navController = navController,
                            game = viewModel.state.value.favorites[it].toGame(),
                        )
                    }
                }
            }

        }
    }
}
