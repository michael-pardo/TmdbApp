package com.mistpaag.databasemanager.di

import android.content.Context
import com.mistpaag.databasemanager.MovieLocalDataSource
import com.mistpaag.data.source.MovieLocalSource
import com.mistpaag.databasemanager.db.MovieDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieLocalModule {
    @Singleton
    @Provides
    fun providesPokemonDB( @ApplicationContext context: Context): MovieDB {
        return MovieDB.build(context, DB_NAME)
    }

    @Singleton
    @Provides
    fun providesLocalSource(
        db: MovieDB
    ): MovieLocalSource {
        return MovieLocalDataSource(db)
    }


}
private const val DB_NAME = "pokedex_db"