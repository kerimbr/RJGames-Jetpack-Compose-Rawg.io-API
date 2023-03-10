package com.example.rjgames.presentation.game_details.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rjgames.data.mapper.toGenre
import com.example.rjgames.data.remote.dto.game_details.GameDetailGenre
import com.example.rjgames.presentation.components.genre_list.GenreListItem

@Composable
fun GameDetailGenres(
    modifier: Modifier = Modifier,
    genres: List<GameDetailGenre?>?,
    onItemClick: (String) -> Unit
) {

    if (genres.isNullOrEmpty()) return

    val scrollState: ScrollState = rememberScrollState()

    Row(modifier = modifier.horizontalScroll(scrollState)) {
        genres.forEach { genre ->
            if(genre == null) return@forEach
            GenreListItem(
                genre = genre.toGenre(),
                onItemClicked = { if (genre.id != null) onItemClick(genre.id.toString()) }
            )
        }
    }

}
