package com.mistpaag.databasemanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mistpaag.domain.Movie

@Entity(tableName = "movies")
data class MovieLocal(
    val adult: Boolean,
    val backdropPath: String,
    @PrimaryKey val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val page: Int
)

fun Movie.toLocal(page: Int) : MovieLocal{
    return MovieLocal(
        adult = adult,
        backdropPath = backdropPath ?: "",
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath ?: "",
        releaseDate = releaseDate ?: "",
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
        page = page
    )
}

fun List<Movie>.toLocal(page: Int) : List<MovieLocal>{
    return this.map { it.toLocal(page) }
}

fun MovieLocal.toDomain() : Movie{
    return Movie(
        adult = adult,
        backdropPath = backdropPath ?: "",
        genreIds = emptyList(),
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath ?: "",
        releaseDate = releaseDate ?: "",
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
    )
}

fun List<MovieLocal>.toDomain() : List<Movie>{
    return this.map { it.toDomain() }
}