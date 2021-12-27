package com.mistpaag.usecases.di

import com.mistpaag.data.MovieRepository
import com.mistpaag.usecases.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MovieUseCasesModule {
    @Provides
    fun provides(
        movieRepository: MovieRepository
    ) = GetPopularMoviesUseCase(
        repository = movieRepository
    )
}