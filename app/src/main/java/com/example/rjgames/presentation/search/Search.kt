package com.example.rjgames.presentation.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.rjgames.presentation.components.CustomTopBar
import com.example.rjgames.presentation.components.MainBottomBar
import com.example.rjgames.presentation.components.SearchBar
import com.example.rjgames.presentation.components.vertical_game_list.verticalGameListWithoutPagination
import com.example.rjgames.presentation.search.components.SearchBodyLottie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: SearchViewModel = hiltViewModel()
) {

    val state: SearchState = viewModel.state.value

    val lazyListState = rememberLazyListState()

    Scaffold(
        topBar = {
            Column(modifier = Modifier) {
                CustomTopBar(subtitle = "Search Games")
                SearchBar(
                    onSearch = { viewModel.getResult(it) }
                )
            }
        },
        bottomBar = { MainBottomBar(navController) }
    ) { paddingValues ->

        // Not Found
        if (state.searchResults.isEmpty() && state.isSearched && !state.isLoading) {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No results found",
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Center
                )
            }
        }

        // First
        if (!state.isSearched && state.searchResults.isEmpty()) {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                SearchBodyLottie()
            }
        }

        // Loading
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }


        // List
        if (state.searchResults.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues),
                state = lazyListState
            ) {

                verticalGameListWithoutPagination(
                    modifier = Modifier.padding(4.dp),
                    list = state.searchResults,
                    navController = navController
                )

            }

        }

    }


}

