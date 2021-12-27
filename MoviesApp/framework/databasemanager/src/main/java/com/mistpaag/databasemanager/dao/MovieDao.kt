package com.mistpaag.databasemanager.dao

import androidx.room.*
import com.mistpaag.databasemanager.model.MovieLocal

@Dao
interface MovieDao {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<MovieLocal>)

    @Query("SELECT * FROM movies WHERE page <= :page ORDER BY page")
    suspend fun getPopularMovies(page: Int): List<MovieLocal>

    @Query("DELETE FROM movies")
    suspend fun clearAll()
}