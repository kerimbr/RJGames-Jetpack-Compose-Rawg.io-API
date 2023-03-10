package com.example.rjgames.di

import android.app.Application
import androidx.room.Room
import com.example.rjgames.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            name = "app_database")
            .build()
    }


    @Provides
    @Singleton
    fun provideFavoritesDao(appDatabase: AppDatabase) = appDatabase.favoritesDao()


}