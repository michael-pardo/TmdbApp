package com.mistpaag.data

import com.mistpaag.domain.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(page: Int) : Flow<ResultData<List<Movie>>>
}