package com.example.rjgames.presentation.game_details.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GameDetailsSectionHeader(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        modifier = modifier.padding(
            horizontal = 16.dp
        ),
        text = title,
        style = MaterialTheme.typography.titleSmall.copy(
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        ),
    )

}

@Preview(name = "GameDetailsSectionHeader")
@Composable
private fun PreviewGameDetailsSectionHeader() {
    GameDetailsSectionHeader(
        title = "Title"
    )
}