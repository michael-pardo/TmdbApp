package com.mistpaag.requestmanager.di

import android.content.Context
import com.mistpaag.requestmanager.R
import com.mistpaag.requestmanager.RetrofitBuild
import com.mistpaag.requestmanager.endpoint.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun providesRetrofitBuild(
        @ApplicationContext context: Context
    ): Retrofit {
        return RetrofitBuild("https://api.themoviedb.org/3/",context.getString(R.string.tmdb_key)).retrofit
    }

    @Provides
    fun providesLocationService(
        retrofit: Retrofit
    ): MovieService {
        return retrofit.create(
            MovieService::class.java
        )
    }
}