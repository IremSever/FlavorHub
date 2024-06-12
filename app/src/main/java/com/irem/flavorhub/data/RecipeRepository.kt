package com.irem.flavorhub.data

import androidx.paging.PagingData
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getRecipes(): Flow<List<Recipe>>
    suspend fun upsertRecipe(recipe: Recipe)
    suspend fun deleteRecipe(recipe: Recipe)
    fun getRecipePagingData(sources: List<String>): Flow<PagingData<Recipe>>
    fun searchRecipe(searchQuery: String, sources: List<String>): Flow<PagingData<Recipe>>
    suspend fun getARecipe(url: String): Recipe?
}
