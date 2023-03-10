package com.example.rjgames.presentation.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rjgames.R
import com.example.rjgames.presentation.raw_jet_game_app.Screens
import com.example.rjgames.presentation.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainBottomBar(
    navController: NavController,
) {

    val screens: List<Screens.BottomBarScreens> = listOf(
        Screens.BottomBarScreens.Discover,
        Screens.BottomBarScreens.Search,
        Screens.BottomBarScreens.Favorites
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomAppBar {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    if (navController.currentDestination?.route != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }

                },
                icon = {
                    BadgedBox(
                        badge = {}
                    ) {
                        if (screen == Screens.BottomBarScreens.Discover) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_sports_esports_24),
                                contentDescription = screen.title,
                            )
                        } else {
                            Icon(
                                imageVector = screen.icon!!,
                                contentDescription = screen.title
                            )
                        }

                    }
                },
                label = {
                    Text(text = screen.title)
                }
            )

        }
    }

}

@Preview
@Composable
fun MainBottomBarPreview() {
    AppTheme {
        MainBottomBar(
            navController = rememberNavController()
        )
    }
}