package com.mistpaag.usecases

import com.mistpaag.data.ResultData
import com.mistpaag.data.MovieRepository
import com.mistpaag.domain.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun invoke(page:Int): Flow<ResultData<List<Movie>>> {
        return repository.getPopularMovies(page)
    }
}