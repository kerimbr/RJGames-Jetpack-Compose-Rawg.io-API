package com.example.rjgames.presentation.components.best_games_of_year_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.rjgames.core.utils.getRatingWithRatingCount
import com.example.rjgames.data.remote.dto.game.GamePlatform
import com.example.rjgames.domain.model.Game
import com.example.rjgames.presentation.components.NetworkImage
import com.example.rjgames.presentation.preview_param_provides.GamePreviewParameterProvider
import com.example.rjgames.presentation.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BestGamesOfYearListItem(
    modifier: Modifier = Modifier,
    game: Game,
    onItemClicked: (Game) -> Unit
) {

    val cardWidth = LocalConfiguration.current.screenWidthDp.dp / 1.7f

    Card(
        modifier = modifier
            .padding(8.dp)
            .width(cardWidth),
        elevation = CardDefaults.elevatedCardElevation(0.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = { onItemClicked(game) },
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.inverseSurface,
        )
    ) {

        NetworkImage(
            modifier = Modifier
                .clip(RoundedCornerShape(
                        topStart = 4.dp, topEnd = 4.dp,
                        bottomStart = 0.dp, bottomEnd = 0.dp
                    )
                )
                .fillMaxWidth()
                .height(120.dp)
                .clipToBounds(),
            url = game.backgroundImage ?: "",
            contentDescription = game.name
        )

/*
        GlideImage(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 4.dp,
                        topEnd = 4.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .fillMaxWidth()
                .height(120.dp)
                .clipToBounds(),
            requestOptions = {
                RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC)
            },
            imageModel = { game.backgroundImage },
            previewPlaceholder = R.drawable.ic_launcher_background,
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
            ),
            loading = {
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topStart = 4.dp, topEnd = 4.dp,
                                bottomStart = 0.dp, bottomEnd = 0.dp
                            )
                        )
                        .fillMaxWidth()
                        .height(120.dp)
                        .clipToBounds()
                        .background(
                            color = MaterialTheme.colorScheme.tertiaryContainer.copy(
                                alpha = 0.3f
                            ),
                        )
                )
            }
        )
*/

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            //PLatforms
            if (game.parrentPlatform != null) {
                ParentPlatformList(parrentPlatform = game.parrentPlatform)
            }

            Text(
                modifier = Modifier.padding(
                    horizontal = 12.dp,
                    vertical = 4.dp
                ),
                text = game.name,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = MaterialTheme.colorScheme.inverseOnSurface,
                    fontWeight = FontWeight.ExtraBold,
                ),
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            // Genres
            if (game.genres != null) {
                GameGenreList(genres = game.genres.map { it.name })
            }
        }



        ListItem(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            headlineText = {
                Text(
                    text = "Release Date",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Normal,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            trailingContent = {
                Text(
                    text = game.released ?: "Unknown",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.ExtraBold,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            colors = ListItemDefaults.colors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                headlineColor = MaterialTheme.colorScheme.onTertiaryContainer,
            ),

            )

        ListItem(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            headlineText = {
                Text(
                    text = "Rating",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Normal,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            trailingContent = {
                Text(
                    text = getRatingWithRatingCount(game),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.ExtraBold,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            colors = ListItemDefaults.colors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                headlineColor = MaterialTheme.colorScheme.onTertiaryContainer,
            ),

            )

    }


}

@Composable
fun ParentPlatformList(
    parrentPlatform: List<GamePlatform>
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        items(parrentPlatform.size) { index ->
            val platform = parrentPlatform[index]

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .padding(horizontal = 2.dp)
                    .background(
                        MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.3f)
                    )
            ) {

                Text(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                        .align(Alignment.Center),
                    text = platform.name,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.SemiBold,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameGenreList(
    genres: List<String>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 4.dp
            ),
            text = "Genres",
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.inverseOnSurface
            )
        )
        Text(
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 4.dp
            ),
            text = genres.joinToString(", "),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.inverseOnSurface
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}


@Composable
fun BestGamesOfYearListItemShimmer() {
    val cardWidth = LocalConfiguration.current.screenWidthDp.dp / 1.7f

    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(300.dp)
            .width(cardWidth),
        elevation = CardDefaults.elevatedCardElevation(0.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.inverseSurface,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer.copy(
                            alpha = 0.3f
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 16.dp)
                    .height(18.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer.copy(
                            alpha = 0.3f
                        ),
                        shape = RoundedCornerShape(4.dp)
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = 8.dp)
                    .height(18.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer.copy(
                            alpha = 0.3f
                        ),
                        shape = RoundedCornerShape(4.dp)
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 8.dp)
                    .height(18.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer.copy(
                            alpha = 0.3f
                        ),
                        shape = RoundedCornerShape(4.dp)
                    )
            )


        }
    }
}

@Preview(name = "BestGamesOfYearListItemShimmer", showBackground = true)
@Composable
private fun PreviewBestGamesOfYearListItemShimmer() {
    AppTheme {
        BestGamesOfYearListItemShimmer()
    }
}


@Preview(name = "BestGamesOfYearListItem", showBackground = true)
@Composable
private fun PreviewBestGamesOfYearListItem(
    @PreviewParameter(GamePreviewParameterProvider::class)
    game: Game
) {
    AppTheme {
        BestGamesOfYearListItem(
            game = game,
            onItemClicked = { }
        )
    }
}
