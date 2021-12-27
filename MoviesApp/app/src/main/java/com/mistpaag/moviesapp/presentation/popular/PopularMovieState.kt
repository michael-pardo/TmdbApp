package com.mistpaag.moviesapp.presentation.popular

import com.mistpaag.domain.Movie


sealed class PopularMovieState {
    data class PopularList(val list: List<Movie>): PopularMovieState()
    data class Error(val message: String): PopularMovieState()
    object Loading: PopularMovieState()
}