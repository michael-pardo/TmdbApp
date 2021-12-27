package com.mistpaag.moviesapp.presentation.detail

import com.mistpaag.moviesapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(

) : BaseViewModel<MovieDetailState>() {

    fun execute(intent: MovieDetailIntent){
        when (intent){
            is MovieDetailIntent.SeeMovieInfo -> _state.value = MovieDetailState.MovieInfo(intent.movie)
        }
    }
}