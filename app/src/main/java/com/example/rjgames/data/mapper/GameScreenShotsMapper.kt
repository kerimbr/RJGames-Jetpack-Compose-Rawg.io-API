package com.example.rjgames.data.mapper

import com.example.rjgames.data.remote.dto.game_screenshots.GameScreenShotResponse


fun GameScreenShotResponse.toGameScreenShots(): List<String?> {
    return results?.map { it?.image } ?: emptyList()
}