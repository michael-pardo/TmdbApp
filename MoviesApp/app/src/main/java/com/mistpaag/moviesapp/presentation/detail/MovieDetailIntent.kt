package com.mistpaag.moviesapp.presentation.detail

import com.mistpaag.domain.Movie

sealed class MovieDetailIntent {
    data class SeeMovieInfo(val movie: Movie): MovieDetailIntent()
}