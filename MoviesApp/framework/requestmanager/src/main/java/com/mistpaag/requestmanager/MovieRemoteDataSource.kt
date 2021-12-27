package com.mistpaag.requestmanager

import com.mistpaag.data.ResultData
import com.mistpaag.data.source.MovieRemoteSource
import com.mistpaag.domain.Movie
import com.mistpaag.requestmanager.endpoint.MovieService
import com.mistpaag.requestmanager.model.MovieResponseRemote
import com.mistpaag.requestmanager.model.toDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieService,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
): MovieRemoteSource {
    private val errorMessage = "Something failed calling service"
    override fun getPopularMovies(page:Int): Flow<ResultData<List<Movie>>> = flow {
        emit(renderData(
            safeApiCall(
                call = { movieService.getPopularMovies(page).callServices() },
                errorMessage = errorMessage
            )
        ))
    }.flowOn(coroutineDispatcher)

    private fun renderData(resultDataList: ResultData<MovieResponseRemote>): ResultData<List<Movie>> {
        return when (resultDataList){
            is ResultData.Error -> ResultData.Error(resultDataList.message)
            is ResultData.Success -> ResultData.Success(resultDataList.data.results.toDomain())
        }
    }
}