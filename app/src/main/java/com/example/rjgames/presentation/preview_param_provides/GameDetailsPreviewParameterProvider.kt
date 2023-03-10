package com.example.rjgames.presentation.preview_param_provides

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.rjgames.data.remote.dto.game_details.*
import com.example.rjgames.domain.model.GameDetails

class GameDetailsPreviewParameterProvider : PreviewParameterProvider<GameDetails> {
    override val values: Sequence<GameDetails>
        get() = sequenceOf(
            GameDetails(
                id = 1,
                name = "Counter Strike: Global Offensive",
                released = "2021-01-01",
                backgroundImage = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507802b2a9d3b32a788.jpg",
                description = "Game 1 description",
                rating = 4.5,
                ratingsCount = 1000,
                genres = listOf(
                    GameDetailGenre(1, 1, "", "Genre 1", "genre 1"),
                    GameDetailGenre(2, 2, "", "Genre 2", "genre 2"),
                    GameDetailGenre(3, 3, "", "Genre 3", "genre 3"),
                    GameDetailGenre(4, 4, "", "Genre 4", "genre 4"),
                    GameDetailGenre(5, 5, "", "Genre 5", "genre 5"),
                ),
                developers = listOf(
                    GameDetailDeveloper(1, 1, "", "Developer 1", "developer 1"),
                    GameDetailDeveloper(2, 2, "", "Developer 2", "developer 2"),
                    GameDetailDeveloper(3, 3, "", "Developer 3", "developer 3"),
                    GameDetailDeveloper(4, 4, "", "Developer 4", "developer 4"),
                    GameDetailDeveloper(5, 5, "", "Developer 5", "developer 5"),
                ),
                publisher = listOf(
                    GameDetailPublisher(1, 1, "", "Publisher 1", "publisher 1"),
                    GameDetailPublisher(2, 2, "", "Publisher 2", "publisher 2"),
                    GameDetailPublisher(3, 3, "", "Publisher 3", "publisher 3"),
                ),
                website = "https://www.google.com",
                playtime = 100,
                screenshots = listOf(
                    "https://media.rawg.io/media/screenshots/84d/84da2ac3fdfc6507802b2a9d3b32a788.jpg",
                    "https://media.rawg.io/media/screenshots/84d/84da2ac3fdfc6507802b2a9d3b32a788.jpg",
                ),
                added = 1000,
                descriptionRaw = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                metacritic = "85",
                parrentPlatforms = listOf(
                    "PC",
                    "PlayStation",
                    "Xbox",
                ),
                platforms = listOf(
                    "PC",
                    "PlayStation 5",
                    "Xbox 360",
                ),
                ratingTop = 5,
                ratings = listOf(
                    GameDetailRating(71, 5, 45.81, "exceptional"),
                    GameDetailRating(46, 4, 29.68, "recommended"),
                    GameDetailRating(16, 3, 10.32, "meh"),
                    GameDetailRating(22, 1, 14.19, "skip"),
                ),
                stores = listOf(
                    GameDetailStoreX("", 72588, 1, "","Steam", "steam" ),
                    GameDetailStoreX("", 72588, 2, "","Steam", "steam" ),
                ),
                tags = listOf(
                    GameDetailTag(1, 1, "", "en", "Action", "action"),
                    GameDetailTag(2, 2, "", "en", "Action", "action"),
                    GameDetailTag(3, 3, "", "en", "Action", "action"),
                    GameDetailTag(4, 4, "", "en", "Action", "action"),
                )
            )
        )
}