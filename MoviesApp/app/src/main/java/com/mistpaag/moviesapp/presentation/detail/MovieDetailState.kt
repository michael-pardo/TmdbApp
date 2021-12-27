package com.mistpaag.moviesapp.presentation.detail

import com.mistpaag.domain.Movie

sealed class MovieDetailState{
    data class MovieInfo(val movie: Movie): MovieDetailState()
}