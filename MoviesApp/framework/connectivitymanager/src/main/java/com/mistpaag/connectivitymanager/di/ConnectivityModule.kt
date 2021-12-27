package com.mistpaag.connectivitymanager.di

import android.content.Context
import com.mistpaag.connectivitymanager.ConnectivityHelper
import com.mistpaag.data.source.ConnectivityChecker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ConnectivityModule {
    @Singleton
    @Provides
    fun providesConnectivityChecker(
        @ApplicationContext context: Context
    ): ConnectivityChecker = ConnectivityHelper(
        context= context
    )
}