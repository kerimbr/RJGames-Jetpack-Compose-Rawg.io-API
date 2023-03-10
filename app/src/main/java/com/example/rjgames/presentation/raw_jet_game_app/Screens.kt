package com.example.rjgames.presentation.raw_jet_game_app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screens(
    val route: String,
    val arguments: List<NamedNavArgument>? = null
    ){

    object GameDetailsScreen : Screens(
        route = "game/details",
        arguments = listOf(
            navArgument("gameId") {
                type = NavType.IntType
            }
        )
    )

    object FilteredGamesScreen : Screens(
        route = "filtered_games",
        arguments = listOf(
            navArgument("gameQueries") {
                type = NavType.StringType
            }
        )
    )


    sealed class BottomBarScreens(
        route: String,
        val title: String,
        val icon: ImageVector? = null
    ) : Screens(route) {

        object Discover : BottomBarScreens(
            route = "discover",
            title = "Discover",
        )

        object Search : BottomBarScreens(
            route = "search",
            title = "Search",
            icon = Icons.Rounded.Search
        )

        object Favorites : BottomBarScreens(
            route = "favorites",
            title = "Favorites",
            icon = Icons.Rounded.Favorite
        )
    }

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/{$arg}")
            }
        }
    }

}
