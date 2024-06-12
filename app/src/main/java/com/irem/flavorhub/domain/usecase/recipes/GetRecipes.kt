package com.irem.flavorhub.domain.usecase.recipes


import androidx.paging.PagingData
import com.irem.flavorhub.data.RecipeRepository
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow

class GetRecipes(
    private val recipeRepository: RecipeRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Recipe>> {
        return recipeRepository.getRecipe(sources = sources)
    }
}