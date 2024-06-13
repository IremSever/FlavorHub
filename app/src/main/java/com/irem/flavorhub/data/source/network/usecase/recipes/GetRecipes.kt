package com.irem.flavorhub.data.source.network.usecase.recipes


import androidx.paging.PagingData
import com.irem.flavorhub.data.RecipeRepository
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipes @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Recipe>> {
        return recipeRepository.getRecipeDet(sources = sources)
    }
}