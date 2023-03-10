package com.example.rjgames.di

import com.example.rjgames.data.repository.RawgRepository
import com.example.rjgames.domain.usecase.FavoriteUseCases
import com.example.rjgames.domain.usecase.GamesUseCases
import com.example.rjgames.domain.usecase.GenreUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGamesUseCases(rawgRepository: RawgRepository): GamesUseCases
        = GamesUseCases(rawgRepository)


    @Provides
    @Singleton
    fun provideGenreUseCase(rawgRepository: RawgRepository) : GenreUseCases
        = GenreUseCases(rawgRepository)


    @Provides
    @Singleton
    fun provideFavoriteUseCase(rawgRepository: RawgRepository) : FavoriteUseCases
        = FavoriteUseCases(rawgRepository)

}