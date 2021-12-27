package com.mistpaag.databasemanager

import com.mistpaag.data.ResultData
import com.mistpaag.data.source.MovieLocalSource
import com.mistpaag.databasemanager.db.MovieDB
import com.mistpaag.databasemanager.model.toDomain
import com.mistpaag.databasemanager.model.toLocal
import com.mistpaag.domain.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(
    db: MovieDB,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): MovieLocalSource {
    private val movieDao = db.movieDao
    override fun getPopularMovies(page: Int): Flow<ResultData<List<Movie>>> = flow {
        emit(
            ResultData.Success(movieDao.getPopularMovies(page).toDomain())
        )
    }.flowOn(dispatcher)

    override fun insertPopularMovies(popularMovies: List<Movie>, page:Int): Flow<ResultData<List<Movie>>> = flow {
        movieDao.insertAll(popularMovies.toLocal(page))
        getPopularMovies(page).collect {
            emit(it)
        }
    }.flowOn(dispatcher)
}