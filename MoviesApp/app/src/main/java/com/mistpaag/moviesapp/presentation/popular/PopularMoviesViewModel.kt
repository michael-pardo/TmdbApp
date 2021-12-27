package com.mistpaag.moviesapp.presentation.popular

import androidx.lifecycle.viewModelScope
import com.mistpaag.data.ResultData
import com.mistpaag.moviesapp.base.BaseViewModel
import com.mistpaag.usecases.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : BaseViewModel<PopularMovieState>() {

    private var currentPage = 1

    fun execute(intent: PopularMovieIntent){
        _state.value = PopularMovieState.Loading
        when (intent){
            PopularMovieIntent.GetPopularMovies -> getMovies()
        }
    }

    fun getMovies(){
        viewModelScope.launch {
            getPopularMoviesUseCase.invoke(currentPage).collect { resultData->
                when (resultData){
                    is ResultData.Error -> _state.value = PopularMovieState.Error(resultData.message)
                    is ResultData.Success -> {
                        currentPage += 1
                        _state.value = PopularMovieState.PopularList(resultData.data)
                    }
                }
            }
        }
    }
}