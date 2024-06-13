package com.irem.flavorhub.data.source.network.usecase.recipes

import com.irem.flavorhub.data.local.RecipeDao
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavRecipes @Inject constructor(
    private val recipeDao: RecipeDao
) {
    operator fun invoke(sourceUrl: String?): Flow<List<Recipe>> {
        return recipeDao.getRecipes()
    }
}
