package com.irem.flavorhub.di

import android.app.Application
import com.irem.flavorhub.data.LocalUserManagerImpl
import com.irem.flavorhub.data.RecipeRepository
import com.irem.flavorhub.data.RecipeRepositoryImpl
import com.irem.flavorhub.data.source.network.RecipeApiService
import com.irem.flavorhub.domain.LocalUserManager
import com.irem.flavorhub.domain.usecase.app_entry.AppEntryUseCases
import com.irem.flavorhub.domain.usecase.app_entry.ReadAppEntry
import com.irem.flavorhub.domain.usecase.app_entry.SaveAppEntry
import com.irem.flavorhub.domain.usecase.recipes.GetRecipes
import com.irem.flavorhub.domain.usecase.recipes.RecipeUseCases
import com.irem.flavorhub.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataProvider {
    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
    @Provides
    @Singleton
    fun provideApiInstance(): RecipeApiService {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(
        recipeApi: RecipeApiService
    ): RecipeRepository {
        return RecipeRepositoryImpl(recipeApi)
    }

    @Provides
    @Singleton
    fun provideRecipeUseCases(
        recipeRepository: RecipeRepository
    ): RecipeUseCases {
        return RecipeUseCases(
            getRecipes = GetRecipes(recipeRepository)
            //searchRecipes = SearchRecipes(recipeRepository)
        )
    }

}