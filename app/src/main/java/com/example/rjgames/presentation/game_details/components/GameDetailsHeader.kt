package com.example.rjgames.presentation.game_details.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.rjgames.domain.model.GameDetails
import com.example.rjgames.presentation.components.NetworkImage

@Composable
fun ColumnScope.GameDetailsHeader(
    modifier: Modifier = Modifier,
    game: GameDetails
) {

    Row {

        NetworkImage(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(80.dp)
                .clip(shape = CircleShape)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    shape = CircleShape
                )
                .align(alignment = Alignment.CenterVertically),
            url = game.backgroundImage?: "",
            contentDescription = game.backgroundImage?: "",
        )


/*
        GlideImage(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(80.dp)
                .clip(shape = CircleShape)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    shape = CircleShape
                )
                .align(alignment = Alignment.CenterVertically),
            imageModel = { game.backgroundImage },
            previewPlaceholder = R.drawable.ic_launcher_background,
            requestOptions = {
                RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC)
            },

        )
*/

        Column{
            Text(
                modifier = modifier.padding(
                    vertical = 8.dp,
                    horizontal = 8.dp
                ),
                text = game.name,
                style = MaterialTheme.typography.displaySmall.copy(
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    fontWeight = FontWeight.Normal
                ),
            )

            Row(
                modifier = modifier
                    .padding(horizontal = 16.dp)
            ){
                Row{
                    Icon(
                        modifier = Modifier.size(16.dp),
                        imageVector = Icons.Rounded.Schedule,
                        contentDescription = "Released",
                    )
                    Text(
                        modifier = Modifier.padding(
                            horizontal = 4.dp
                        ),
                        text = game.released?:"Unknown",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            fontWeight = FontWeight.Normal
                        ),
                    )
                }

                Spacer(Modifier.width(32.dp))

                Row{
                    Icon(
                        modifier = Modifier.size(16.dp),
                        imageVector = Icons.TwoTone.Person,
                        contentDescription = "Added",
                    )
                    Text(
                        modifier = Modifier.padding(
                            horizontal = 4.dp
                        ),
                        text = game.added?.toString()?:"Unknown",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            fontWeight = FontWeight.Normal
                        ),
                    )
                }


            }
        }

    }




}
