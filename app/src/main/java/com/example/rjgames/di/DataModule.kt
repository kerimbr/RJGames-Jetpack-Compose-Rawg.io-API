package com.example.rjgames.di

import com.example.rjgames.data.local.database.dao.FavoritesDao
import com.example.rjgames.data.remote.RawgAPIService
import com.example.rjgames.data.repository.RawgRepository
import com.example.rjgames.domain.repository.RawgRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRawgRepository(
        rawgAPIService: RawgAPIService,
        favoritesDao: FavoritesDao
    ): RawgRepository {
        return RawgRepositoryImpl(
            rawgAPIService,
            favoritesDao
        )
    }



}