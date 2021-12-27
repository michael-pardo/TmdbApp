package com.mistpaag.data.source


import com.mistpaag.data.ResultData
import com.mistpaag.domain.Movie
import kotlinx.coroutines.flow.Flow

interface MovieLocalSource {
    fun getPopularMovies(page: Int): Flow<ResultData<List<Movie>>>
    fun insertPopularMovies(popularMovies: List<Movie>, page:Int): Flow<ResultData<List<Movie>>>
}