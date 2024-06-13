package com.irem.flavorhub.di


import android.app.Application
import androidx.room.Room
import com.irem.flavorhub.data.local.RecipeDao
import com.irem.flavorhub.data.local.RecipeDatabase
import com.irem.flavorhub.data.local.RecipeType
import com.irem.flavorhub.data.source.network.RecipeApiService
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
    fun provideRecipeDatabase(
        application: Application
    ): RecipeDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = RecipeDatabase::class.java,
            name = "recipe_db"
        ).addTypeConverter(RecipeType())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideRecipeDao(
        recipeDatabase: RecipeDatabase
    ): RecipeDao = recipeDatabase.recipeDao()


}