package com.captvelsky.descam.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.captvelsky.descam.data.remote.ApiConfig
import com.captvelsky.descam.data.remote.ApiServiceDatabase
import com.captvelsky.descam.data.remote.ApiServiceModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        context.dataStore

    @Provides
    fun provideApiServiceModel(): ApiServiceModel = ApiConfig.getApiServiceModel()

    @Provides
    fun provideApiServiceDatabase(): ApiServiceDatabase = ApiConfig.getApiServiceDatabase()
}