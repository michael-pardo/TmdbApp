package com.mistpaag.requestmanager.di

import com.mistpaag.data.source.MovieRemoteSource
import com.mistpaag.requestmanager.MovieRemoteDataSource
import com.mistpaag.requestmanager.endpoint.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MovieRemoteModule {

    @Provides
    fun providesPokemonRemoteSource(
        movieService: MovieService
    ): MovieRemoteSource = MovieRemoteDataSource(
        movieService = movieService
    )
}