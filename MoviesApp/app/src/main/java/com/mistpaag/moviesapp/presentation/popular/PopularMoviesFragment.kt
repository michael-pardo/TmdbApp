package com.mistpaag.moviesapp.presentation.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mistpaag.domain.Movie
import com.mistpaag.moviesapp.MovieAdapter
import com.mistpaag.moviesapp.databinding.PopularMoviesFragmentBinding
import com.mistpaag.moviesapp.parcelables.toParcelable
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {
    private val viewModel by viewModels<PopularMoviesViewModel>()
    private lateinit var binding: PopularMoviesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PopularMoviesFragmentBinding.inflate(inflater, container, false)
        setupUI()
        viewModel.execute(PopularMovieIntent.GetPopularMovies)
        return binding.root
    }

    private fun setupUI() {
        val adapter = MovieAdapter{ movieItem->
            goToMovie(movieItem)
        }
        binding.popularMoviesRecycler.adapter = adapter
        setupRecycler()

        viewModel.state.observe(viewLifecycleOwner,{ state ->
            binding.progressBar.isVisible = state is PopularMovieState.Loading
            when (state) {
                is PopularMovieState.Error -> showToast(state.message)
                PopularMovieState.Loading -> {}
                is PopularMovieState.PopularList -> adapter.submitList(state.list.toMutableList())
            }
        })
    }

    private fun showToast(message: String){
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }


    private fun setupRecycler(){
        binding.popularMoviesRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE ) {
                    viewModel.execute(PopularMovieIntent.GetPopularMovies)
                }
            }
        })
    }

    private fun goToMovie(movie: Movie){
        findNavController().navigate(
            PopularMoviesFragmentDirections
                .actionPopularMoviesFragmentToMovieDetailFragment(movie.toParcelable())
        )
    }

}