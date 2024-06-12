package com.irem.flavorhub.di

import com.irem.flavorhub.data.RecipeRepository
import com.irem.flavorhub.data.RecipeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNewsRepository(newsRepositoryImpl: RecipeRepositoryImpl): RecipeRepository

}