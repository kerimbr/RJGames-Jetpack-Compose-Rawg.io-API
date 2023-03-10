package com.example.rjgames.data.remote

import com.example.rjgames.data.remote.dto.game.GamesResponse
import com.example.rjgames.data.remote.dto.game_details.GameDetailsResponse
import com.example.rjgames.data.remote.dto.game_screenshots.GameScreenShotResponse
import com.example.rjgames.data.remote.dto.genre.GenresResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RawgAPIService {

    @GET("genres")
    suspend fun getGenres(
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null,
        @Query("ordering") ordering: String? = null,
    ): GenresResponse

    @GET("games")
    suspend fun getGames(
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null,
        @Query("search") search: String? = null,
        @Query("parent_platforms") parentPlatforms: String? = null,
        @Query("genres") genres: String? = null,
        @Query("platforms") platforms: String? = null,
        @Query("stores") stores: String? = null,
        @Query("developers") developers: String? = null,
        @Query("publishers") publishers: String? = null,
        @Query("tags") tags: String? = null,
        @Query("dates") dates: String? = null,
        @Query("ordering") ordering: String? = null,
    ): GamesResponse

    @GET("games/{id}")
    suspend fun getGameDetails(
        @Path("id") id: Int,
    ): GameDetailsResponse

    @GET("games/{id}/screenshots")
    suspend fun getGameScreenshots(
        @Path("id") id: Int,
    ): GameScreenShotResponse


}