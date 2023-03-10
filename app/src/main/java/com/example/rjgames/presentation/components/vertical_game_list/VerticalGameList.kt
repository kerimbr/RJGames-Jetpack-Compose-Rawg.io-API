package com.example.rjgames.presentation.components.vertical_game_list

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.rjgames.domain.model.Game

fun LazyListScope.verticalGameListWithoutPagination(
    modifier: Modifier,
    navController: NavController,
    list: List<Game>,
) {
    items(list.size) { index ->
        VerticalGameListItem(
            game = list[index],
            navController = navController
        )
    }
}


fun LazyListScope.verticalGameListWithPagination(
    listWithPagination: LazyPagingItems<Game>,
    navController: NavController,
) {

    items(listWithPagination.itemCount) { i: Int ->
        listWithPagination[i]?.let {
            VerticalGameListItem(
                game = it,
                navController = navController
            )
        }
    }

    // Add more loading states

    item {
        when (val state = listWithPagination.loadState.refresh) {
            is LoadState.Loading -> {
                (0..5).forEach { _ ->
                    VerticalGameListItemShimmer()
                }
            }

            is LoadState.Error -> {
                Text(text = "Error: ${state.error.localizedMessage}")

            }

            else -> {}
        }
    }

/*
        // First Load
        when (val state = listWithPagination.loadState.refresh) {
            is LoadState.Loading -> {
                (0..5).forEach { _ ->
                    VerticalGameListItemShimmer()
                }
            }

            is LoadState.Error -> {
                Text(text = "Error: ${state.error.localizedMessage}")

            }

            else -> {}
        }

        // Page Load
        when (val state = listWithPagination.loadState.append) {
            is LoadState.Loading -> {
                CircularProgressIndicator()
            }

            is LoadState.Error -> {
                Text(text = "Error: ${state.error.localizedMessage}")

            }

            else -> {}
        }
    }*/




}