package com.example.rjgames.presentation.raw_jet_game_app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rjgames.presentation.ui.theme.AppTheme


@Composable
fun RawJetGamesApp() {
    val navController: NavController = rememberNavController()

    AppTheme(useDarkTheme = isSystemInDarkTheme()) {
        Navigation(
            modifier = Modifier,
            navController = navController as NavHostController
        )
    }
}


@Preview
@Composable
fun RawJetGamesAppPreview() {
    AppTheme {
        RawJetGamesApp()
    }
}