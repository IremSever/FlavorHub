package com.irem.flavorhub.data

import androidx.paging.PagingData
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getRecipe(sources: List<String>): Flow<PagingData<Recipe>>

    fun searchRecipe(searchQuery: String, sources: List<String>): Flow<PagingData<Recipe>>
}