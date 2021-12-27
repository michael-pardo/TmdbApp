package com.mistpaag.imagemanager

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String){
    Glide.with(this.context)
        .load(url.getMediaURL())
        .centerCrop()
        .into(this)
}

fun String.getMediaURL() = "https://image.tmdb.org/t/p/w400/$this"
fun String.getMediaURLBack() = "https://image.tmdb.org/t/p/w780/$this"