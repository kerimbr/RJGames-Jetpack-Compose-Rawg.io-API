package com.example.rjgames.presentation.components.genre_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.rjgames.domain.model.Genre
import com.example.rjgames.presentation.components.NetworkImage
import com.example.rjgames.presentation.preview_param_provides.GenrePreviewParameterProvider
import com.example.rjgames.presentation.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenreListItem(
    genre: Genre,
    onItemClicked: (genre: Genre) -> Unit
) {

    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(4.dp)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(
                alpha = 0.1f
            ),
        ),
        onClick = { onItemClicked(genre) }
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clipToBounds(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            NetworkImage(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .clip(CircleShape),
                url = genre.imageBackground ?: "",
                contentDescription = genre.name,
            )

/*
            GlideImage(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .clip(CircleShape),
                requestOptions = {
                    RequestOptions().diskCacheStrategy(
                        DiskCacheStrategy.AUTOMATIC
                    )
                },
                imageModel = { genre.imageBackground },
                previewPlaceholder = R.drawable.ic_launcher_background,
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                ),
                loading = {
                    Box(
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                    )
                },
            )
*/

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = genre.name,
                style = MaterialTheme.typography.labelMedium.copy(
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Medium
                )
            )

        }
    }

}


@Composable
fun GenreListItemShimmer() {
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(4.dp)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(
                alpha = 0.1f
            ),
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clipToBounds(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .clip(CircleShape),
                color = MaterialTheme.colorScheme.secondaryContainer
            ){}

            Box(
                modifier = Modifier
                    .height(16.dp)
                    .width(60.dp)
                    .padding(top = 4.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        color = MaterialTheme.colorScheme.secondaryContainer.copy(
                            alpha = 0.5f
                        )
                    )
            )

        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun GenreListItemShimmerPreview() {
    AppTheme {
        GenreListItemShimmer()
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun GenreListItemPreview(@PreviewParameter(GenrePreviewParameterProvider::class) genre: Genre) {
    AppTheme {
        GenreListItem(genre = genre) {}
    }
}
