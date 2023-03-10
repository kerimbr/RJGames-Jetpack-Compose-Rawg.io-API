package com.example.rjgames.presentation.preview_param_provides

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.rjgames.data.remote.dto.game.GameGenre
import com.example.rjgames.data.remote.dto.game.GamePlatform
import com.example.rjgames.domain.model.Game

class GamePreviewParameterProvider: PreviewParameterProvider<Game> {
    override val values: Sequence<Game>
        get() = sequenceOf(
            Game(
                id = 1,
                name = "S.T.A.L.K.E.R. 2: Heart of Chornobyl",
                released = "2021-01-01",
                backgroundImage = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507800d2f8b3b9e8a1b.jpg",
                rating = 4.5,
                ratingsCount = 1000,
                genres = listOf(
                    GameGenre(
                        id = 0,
                        name = "Action",
                        slug = "action"
                    ),
                    GameGenre(
                        id = 1,
                        name = "Adventure",
                        slug = "adventure"
                    ),
                    GameGenre(
                        id = 2,
                        name = "RPG",
                        slug = "rpg"
                    ),
                    GameGenre(
                        id = 3,
                        name = "Shooter",
                        slug = "shooter"
                    ),
                ),
                parrentPlatform = listOf(
                    GamePlatform(
                        id = 0,
                        name = "PC",
                        slug = "pc"
                    ),
                    GamePlatform(
                        id = 1,
                        name = "PS4",
                        slug = "ps4"
                    ),

                    GamePlatform(
                        id = 0,
                        name = "PC",
                        slug = "pc"
                    ),
                    GamePlatform(
                        id = 1,
                        name = "PS4",
                        slug = "ps4"
                    ),

                    GamePlatform(
                        id = 0,
                        name = "PC",
                        slug = "pc"
                    ),
                    GamePlatform(
                        id = 1,
                        name = "PS4",
                        slug = "ps4"
                    ),

                    GamePlatform(
                        id = 0,
                        name = "PC",
                        slug = "pc"
                    ),
                    GamePlatform(
                        id = 1,
                        name = "PS4",
                        slug = "ps4"
                    ),

                    GamePlatform(
                        id = 0,
                        name = "PC",
                        slug = "pc"
                    ),
                    GamePlatform(
                        id = 1,
                        name = "PS4",
                        slug = "ps4"
                    ),
                ),
            )
        )
}