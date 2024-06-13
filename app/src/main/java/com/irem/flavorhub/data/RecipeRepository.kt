package com.irem.flavorhub.data

import androidx.paging.PagingData
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getRecipeDet(sources: List<String>): Flow<PagingData<Recipe>>
    fun searchRecipe(searchQuery: String, sources: List<String>): Flow<PagingData<Recipe>>
    suspend fun upsertRecipe(recipe: Recipe)
    suspend fun deleteRecipe(recipe: Recipe)
    fun getRecipes(): Flow<List<Recipe>>
    suspend fun getRecipe(url: String): Recipe?
}
