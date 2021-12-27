package com.mistpaag.moviesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mistpaag.domain.Movie
import com.mistpaag.imagemanager.loadImage
import com.mistpaag.moviesapp.databinding.MovieItemBinding
import com.mistpaag.moviesapp.utils.DiffCallback

class MovieAdapter(val itemClick:(Movie) -> Unit) :
    ListAdapter<Movie, MovieAdapter.ViewHolder>(
        DiffCallback<Movie>(
            {old, new -> old == new},
            { old: Movie, new: Movie -> old.id == new.id}
        )
    ){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder( MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false) )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo( getItem(position) )
    }

    inner class ViewHolder(
        private val binding: MovieItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bindTo(item: Movie){
            binding.apply {
                titleText.text = item.title
                backgroundImage.loadImage(item.posterPath)
                cardContainer.setOnClickListener { itemClick(item) }
            }
        }
    }


}