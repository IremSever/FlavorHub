package com.irem.flavorhub.data.source.network.usecase.recipes

import com.irem.flavorhub.data.local.RecipeDao
import com.irem.flavorhub.model.Recipe
import javax.inject.Inject

class GetFavRecipe @Inject constructor(
    private val recipeDao: RecipeDao
) {
    suspend operator fun invoke(url: String): Recipe? {
        return recipeDao.getRecipe(url)
    }
}

