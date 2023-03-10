package com.example.rjgames.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rjgames.data.local.converters.Converter
import com.example.rjgames.data.local.database.dao.FavoritesDao
import com.example.rjgames.domain.model.GameDetails


@TypeConverters(
    Converter::class
)
@Database(
    entities = [
        GameDetails::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase(){

    abstract fun favoritesDao(): FavoritesDao

}