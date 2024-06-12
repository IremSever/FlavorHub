package com.irem.flavorhub.domain.usecase.recipes

import com.irem.flavorhub.data.local.RecipeDao
import com.irem.flavorhub.model.Recipe

class UpsertRecipe(
    private val recipeDao: RecipeDao
) {
    suspend operator fun invoke(recipe: Recipe){
        recipeDao.upsert(recipe = recipe)
    }
}