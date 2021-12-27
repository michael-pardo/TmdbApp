package com.mistpaag.requestmanager.endpoint

import com.mistpaag.requestmanager.model.MovieResponseRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page:Int
    ) : Response<MovieResponseRemote>
}