package com.example.rjgames.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rjgames.domain.model.GameDetails
import kotlinx.coroutines.flow.Flow


@Dao
interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(gameDetails: GameDetails) : Long

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): Flow<List<GameDetails>>

    @Query("DELETE FROM favorites WHERE id = :id")
    fun deleteFavorite(id: Int) : Int

    @Query("SELECT EXISTS(SELECT * FROM favorites WHERE id = :id)")
    fun isFavorite(id: Int): Boolean

}