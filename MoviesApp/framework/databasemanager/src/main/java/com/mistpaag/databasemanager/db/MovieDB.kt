package com.mistpaag.databasemanager.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mistpaag.databasemanager.dao.MovieDao
import com.mistpaag.databasemanager.model.MovieLocal

@Database(entities = [
    MovieLocal::class,
], version =1, exportSchema = false)
abstract class MovieDB : RoomDatabase() {
    companion object {
        fun build(context: Context, dbName: String) = Room.databaseBuilder(
            context,
            MovieDB::class.java,
            dbName
        ).build()
    }

    //    Movies
    abstract val movieDao: MovieDao
}