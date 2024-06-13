package com.irem.flavorhub.domain.usecase.recipes

import androidx.paging.PagingData
import com.irem.flavorhub.data.RecipeRepository
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow

class SearchRecipe(
    private val recipeRepository: RecipeRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Recipe>> {
        return recipeRepository.searchRecipe(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}

