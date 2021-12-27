package com.mistpaag.moviesapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mistpaag.domain.Movie
import com.mistpaag.moviesapp.databinding.MovieDetailFragmentBinding
import com.mistpaag.moviesapp.parcelables.toDomain
import com.mistpaag.moviesapp.presentation.detail.compose.MovieDetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private val viewModel by viewModels<MovieDetailViewModel>()
    private lateinit var binding: MovieDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MovieDetailFragmentBinding.inflate(inflater, container, false)

        setupUI()

        return binding.root
    }

    private fun setupUI() {
        viewModel.state.observe(viewLifecycleOwner,{ state->
            when (state){
                is MovieDetailState.MovieInfo -> seeMovieScreen(state.movie)
            }
        })
        
        binding.composeContainer.setContent { 
            Text(text = "Loading")
        }
    }

    private fun seeMovieScreen(movie: Movie){
        binding.composeContainer.setContent {
            MovieDetailScreen(movie = movie)
        }
    }

    override fun onStart() {
        super.onStart()
        getArguments(arguments)
    }

    private fun getArguments(arguments: Bundle?) {
        arguments?.let {
            val movie = MovieDetailFragmentArgs.fromBundle(it).movie.toDomain()
            viewModel.execute(
                MovieDetailIntent.SeeMovieInfo(movie)
            )
        }
    }

}