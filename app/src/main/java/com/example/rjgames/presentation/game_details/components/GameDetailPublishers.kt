package com.example.rjgames.presentation.game_details.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.rjgames.data.remote.dto.game_details.GameDetailPublisher
import com.example.rjgames.presentation.components.NetworkImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnScope.GameDetailPublishers(
    publishers: List<GameDetailPublisher?>
) {

    publishers.forEach {

        ListItem(
            modifier = Modifier.padding(
                horizontal = 8.dp,
                vertical = 8.dp
            ),
            colors = ListItemDefaults.colors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                headlineColor = MaterialTheme.colorScheme.onTertiaryContainer,
            ),
            headlineText = {
                Text(
                    text = it?.name ?: "Unknown",
                    fontWeight = FontWeight.Bold
                )
            },
            leadingContent = {

                NetworkImage(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    url = it?.imageBackground ?: "",
                    contentDescription = it?.name ?: ""
                )

/*
                GlideImage(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    imageModel = {
                        it?.imageBackground ?: ""
                    },
                    loading = {
                        CircularProgressIndicator()
                    },
                    failure = {
                        Icon(
                            imageVector = Icons.Rounded.Person,
                            contentDescription = "Publisher"
                        )
                    }
                )
*/
            }
        )
    }


}