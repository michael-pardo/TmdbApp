package com.mistpaag.moviesapp.presentation.popular

sealed class PopularMovieIntent {
    object GetPopularMovies: PopularMovieIntent()
}