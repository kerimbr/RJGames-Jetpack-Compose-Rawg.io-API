package com.example.rjgames.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rjgames.presentation.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SectionTitleWithButton(
    modifier: Modifier = Modifier,
    title: String = "Item Title",
    buttonText: String? = null,
    onClick: (() -> Unit)? = null
) {
    ListItem(
        modifier = modifier,
        headlineText = {
            Text(
                title,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                ),
            )
        },

        trailingContent = {
            if (buttonText == null || onClick == null) return@ListItem
            TextButton(
                modifier = Modifier
                    .padding(start = 16.dp),
                onClick = onClick
            ) {
                Text(
                    buttonText,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.primary
                    ),
                )
            }

        },

        )
}

@Preview(name = "SectionTitleWithButton")
@Composable
private fun PreviewSectionTitleWithButton() {
    AppTheme {
        SectionTitleWithButton()
    }
}