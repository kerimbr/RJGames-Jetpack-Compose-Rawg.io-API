package com.example.rjgames.presentation.game_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.rjgames.domain.model.GameDetails
import com.example.rjgames.presentation.preview_param_provides.GameDetailsPreviewParameterProvider

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ColumnScope.GameDetailsRatingBar(
    modifier: Modifier = Modifier,
    game: GameDetails
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        game.ratings?.forEachIndexed() { index, rating ->
            if (rating == null) return@forEachIndexed
            val percent: Float = (rating.percent?.toFloat()?.div(100)) ?: 0f
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .weight(percent)
                    .clip(
                        shape = when (index) {
                            0 -> RoundedCornerShape(
                                topStart = 4.dp,
                                bottomStart = 4.dp
                            )

                            game.ratings.size - 1 -> RoundedCornerShape(
                                topEnd = 4.dp,
                                bottomEnd = 4.dp
                            )

                            else -> RoundedCornerShape(0.dp)
                        }
                    )

                    .background(
                        color = when (rating.id) {
                            5 -> MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
                            4 -> MaterialTheme.colorScheme.secondary.copy(alpha = 0.8f)
                            3 -> MaterialTheme.colorScheme.tertiary.copy(alpha = 0.8f)
                            1 -> MaterialTheme.colorScheme.error.copy(alpha = 0.8f)
                            else -> MaterialTheme.colorScheme.error.copy(alpha = 0.8f)
                        }
                    )
            )
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    FlowRow(modifier = modifier.padding(horizontal = 16.dp)) {
        game.ratings?.forEach {
            if (it == null) return@forEach
            val percent: Float = (it.percent?.toFloat()?.div(100)) ?: 0f
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.Gray.copy(alpha = 0.2f))
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(
                            color = when (it.id) {
                                5 -> MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
                                4 -> MaterialTheme.colorScheme.secondary.copy(alpha = 0.8f)
                                3 -> MaterialTheme.colorScheme.tertiary.copy(alpha = 0.8f)
                                1 -> MaterialTheme.colorScheme.error.copy(alpha = 0.8f)
                                else -> MaterialTheme.colorScheme.error.copy(alpha = 0.8f)
                            }
                        ).align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp )) {
                    Text(
                        text = it.title ?: "",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)
                    )
                    Text(
                        text = "${it.count ?: 0} votes",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)
                    )
                }
            }
        }
    }

}

@Preview(name = "GameDetailsRatingBar", showBackground = true)
@Composable
private fun PreviewGameDetailsRatingBar(
    @PreviewParameter(GameDetailsPreviewParameterProvider::class)
    game: GameDetails
) {
    Column {
        GameDetailsRatingBar(game = game)
    }
}