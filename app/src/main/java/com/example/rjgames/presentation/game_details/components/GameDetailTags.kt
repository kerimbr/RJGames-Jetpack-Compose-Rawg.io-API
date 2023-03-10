package com.example.rjgames.presentation.game_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.rjgames.data.remote.dto.game_details.GameDetailTag

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GameDetailTags(
    tags: List<GameDetailTag>
) {

    FlowRow(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        tags.forEach {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        MaterialTheme.colorScheme.secondaryContainer
                            .copy(alpha = 0.1f)
                    )
                    .padding(8.dp)
            ) {
                Text(
                    text =  "#${it.name}",
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = TextUnit(12f, TextUnitType.Sp)
                    )
                )
            }
        }

    }


}