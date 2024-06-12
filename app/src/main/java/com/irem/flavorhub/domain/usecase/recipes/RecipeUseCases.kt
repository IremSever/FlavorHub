package com.irem.flavorhub.domain.usecase.recipes

import androidx.paging.PagingData
import com.irem.flavorhub.data.RecipeRepository
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow

data class RecipeUseCases(private val recipeRepository: RecipeRepository) {
    suspend fun searchRecipe(searchQuery: String, sources: List<String>): Flow<PagingData<Recipe>> {
        return recipeRepository.searchRecipe(searchQuery, sources)
    }
}