package com.mistpaag.data

import com.mistpaag.data.source.ConnectivityChecker
import com.mistpaag.data.source.MovieLocalSource
import com.mistpaag.data.source.MovieRemoteSource
import com.mistpaag.domain.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteSource: MovieRemoteSource,
    private val localSource: MovieLocalSource,
    private val connectivityChecker: ConnectivityChecker
): MovieRepository {
    override fun getPopularMovies(page:Int): Flow<ResultData<List<Movie>>> = flow {
        if (connectivityChecker.isInternetAvailable()){
            remoteSource.getPopularMovies(page).collect { remoteData->
                when (remoteData){
                    is ResultData.Error -> {}
                    is ResultData.Success -> {
                        localSource.insertPopularMovies(remoteData.data, page).collect {}
                    }
                }
                localSource.getPopularMovies(page).collect { emit(it) }
            }
        }else{
            localSource.getPopularMovies(page).collect { emit(it) }
        }
    }
}