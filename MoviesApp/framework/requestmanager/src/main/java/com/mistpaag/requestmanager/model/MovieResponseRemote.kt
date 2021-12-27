package com.mistpaag.requestmanager.model

import com.google.gson.annotations.SerializedName

data class MovieResponseRemote(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieRemote>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)