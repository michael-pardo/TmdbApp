package com.mistpaag.data.di

import com.mistpaag.data.MovieRepository
import com.mistpaag.data.MovieRepositoryImpl
import com.mistpaag.data.source.ConnectivityChecker
import com.mistpaag.data.source.MovieLocalSource
import com.mistpaag.data.source.MovieRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MovieRepositoryModule {
    @Provides
    fun providesLocationRepository(
        movieRemoteSource: MovieRemoteSource,
        movieLocalSource: MovieLocalSource,
        connectivityChecker: ConnectivityChecker
    ): MovieRepository = MovieRepositoryImpl(
        remoteSource = movieRemoteSource,
        localSource = movieLocalSource,
        connectivityChecker = connectivityChecker
    )
}