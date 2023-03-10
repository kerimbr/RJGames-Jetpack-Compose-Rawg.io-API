package com.example.rjgames.presentation.components.vertical_game_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rjgames.core.utils.getRatingWithRatingCount
import com.example.rjgames.domain.model.Game
import com.example.rjgames.presentation.components.NetworkImage
import com.example.rjgames.presentation.preview_param_provides.GamePreviewParameterProvider
import com.example.rjgames.presentation.raw_jet_game_app.Screens
import com.example.rjgames.presentation.ui.theme.AppTheme

@Composable
fun VerticalGameListItem(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    game: Game,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clip(
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                MaterialTheme.colorScheme.secondaryContainer
                    .copy(alpha = 0.1f)
            )
            .clickable {
                val route = Screens.GameDetailsScreen.route + "/${game.id}"
                println("route: $route")
                navController?.navigate(route)
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {

            NetworkImage(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .height(100.dp)
                    .width(100.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                url = game.backgroundImage?: "",
                contentDescription = game.backgroundImage?: "",
            )

            Column(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .height(100.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    modifier = Modifier.padding(
                        horizontal = 12.dp,
                        vertical = 4.dp
                    ),
                    text = game.name,
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        fontWeight = FontWeight.ExtraBold,
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Row(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = modifier.size(20.dp),
                        imageVector = Icons.Rounded.Star,
                        contentDescription = "Rating Icon",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        modifier = modifier.padding(horizontal = 4.dp),
                        text = getRatingWithRatingCount(game),
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    )
                }

                game.genres?.joinToString(", ") { it.name }?.let {
                    Text(
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 4.dp
                        ),
                        text = it,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

            }

        }
    }

}


@Composable
fun VerticalGameListItemShimmer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(
                MaterialTheme.colorScheme.secondaryContainer
                    .copy(alpha = 0.1f)
            )
    ) {
        Row {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .background(
                        MaterialTheme.colorScheme.primary.copy(
                            alpha = 0.3f
                        )
                    )
            )

            Column(
                modifier = Modifier.height(100.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .height(20.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp))
                        .background(
                            MaterialTheme.colorScheme.primary.copy(
                                alpha = 0.1f
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .height(16.dp)
                        .fillMaxWidth(0.3f)
                        .clip(shape = RoundedCornerShape(4.dp))
                        .background(
                            MaterialTheme.colorScheme.primary.copy(
                                alpha = 0.1f
                            )
                        )
                )

                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .height(12.dp)
                        .fillMaxWidth(0.7f)
                        .clip(shape = RoundedCornerShape(4.dp))
                        .background(
                            MaterialTheme.colorScheme.primary.copy(
                                alpha = 0.1f
                            )
                        )
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewVerticalGameListItemShimmer() {
    AppTheme {
        VerticalGameListItemShimmer()
    }
}

@Preview(name = "VerticalGameListItem", showBackground = true)
@Composable
private fun PreviewVerticalGameListItem(
    @PreviewParameter(GamePreviewParameterProvider::class)
    game: Game
) {
    AppTheme {
        VerticalGameListItem(game = game)
    }
}
