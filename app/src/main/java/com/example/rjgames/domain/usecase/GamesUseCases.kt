package com.example.rjgames.domain.usecase

import androidx.paging.PagingData
import com.example.rjgames.core.constants.DISCOVER_PAGE_SIZE
import com.example.rjgames.core.enums.GamesOrderType
import com.example.rjgames.core.utils.yearStringToDateRangeString
import com.example.rjgames.data.Resource
import com.example.rjgames.data.mapper.toGameDetails
import com.example.rjgames.data.mapper.toGameList
import com.example.rjgames.data.mapper.toGameScreenShots
import com.example.rjgames.data.repository.RawgRepository
import com.example.rjgames.domain.model.Game
import com.example.rjgames.domain.model.GameDetails
import com.example.rjgames.domain.model.GameQueries
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GamesUseCases @Inject constructor(
    private val rawgRepository: RawgRepository
) {

    fun getGamesBestOfYear(year: String): Flow<Resource<List<Game>>> = flow {
        try {
            emit(Resource.Loading())

            val date: String = yearStringToDateRangeString(year)

            val list: List<Game> = rawgRepository
                .getGames(
                    gameQueries = GameQueries(
                        page = 1,
                        pageSize = DISCOVER_PAGE_SIZE,
                        ordering = GamesOrderType.ADDED.reverse(),
                        dates = date
                    )
                ).toGameList()

            emit(Resource.Success(list))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }


    fun getSearchResults(query: String): Flow<Resource<List<Game>>> = flow {
        try {
            emit(Resource.Loading())

            val list: List<Game> = rawgRepository
                .getGames(
                    gameQueries = GameQueries(
                        page = 1,
                        pageSize = DISCOVER_PAGE_SIZE,
                        ordering = GamesOrderType.ADDED.reverse(),
                        search = query
                    )
                ).toGameList()


            emit(Resource.Success(list))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }


    fun getBestOfAllTimeWithPagination(): Flow<PagingData<Game>> =
        rawgRepository.getBestOfAllTimeWithPagination()


    fun getGameDetails(id: Int): Flow<Resource<GameDetails>> = flow {
        try {
            emit(Resource.Loading())


            var game: GameDetails = rawgRepository
                .getGameDetails(id).toGameDetails()

            val screenshots: List<String?> = rawgRepository
                .getGameScreenshots(id)
                .toGameScreenShots()

            game = game.copy(screenshots = screenshots)


            emit(Resource.Success(game))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

    fun getGamesWithQueries(gameQueries: GameQueries): Flow<Resource<List<Game>>> = flow {
        try {
            emit(Resource.Loading())

            val list: List<Game> = rawgRepository
                .getGames(
                    gameQueries = gameQueries
                ).toGameList()

            emit(Resource.Success(list))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }


}