package com.example.rjgames.presentation.preview_param_provides

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.rjgames.domain.model.Genre

class GenrePreviewParameterProvider : PreviewParameterProvider<Genre> {
    override val values: Sequence<Genre>
        get() = sequenceOf(
            Genre(
                id = 1,
                name = "Action",
                slug = "action",
                gamesCount = 100,
                imageBackground = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507802c2f8b32a67a1b.jpg"
            )
        )
}