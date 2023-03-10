package com.example.rjgames.presentation.game_details.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailsTopBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    isFavorite: Boolean = false,
    onChangeFavorite: (Boolean) -> Unit = { }
) {

    var isFavoriteState by remember { mutableStateOf(isFavorite) }

    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        ),
        title = {},
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
        },
        actions = {

            if (isFavoriteState) {
                Button(
                    modifier = Modifier.padding(
                        end = 16.dp
                    ).animateContentSize(),
                    onClick = {
                        onChangeFavorite(false)
                        isFavoriteState = false
                    },
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError
                    )
                ) {
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = "Add to favorites",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Remove to favorites")
                }

            } else {
                Button(
                    modifier = Modifier.padding(
                        end = 16.dp
                    ).animateContentSize(),
                    onClick = {
                        onChangeFavorite(true)
                        isFavoriteState = true
                    },
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding
                ) {
                    Icon(
                        Icons.Rounded.Favorite,
                        contentDescription = "Add to favorites",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Add to favorites")
                }

            }

        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    )
}

@Preview(name = "GameDetailsTopBar")
@Composable
private fun PreviewGameDetailsTopBar() {
    GameDetailsTopBar(
        navController = rememberNavController(),
    )

}