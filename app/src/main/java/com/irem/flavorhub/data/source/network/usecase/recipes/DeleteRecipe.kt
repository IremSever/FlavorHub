package com.irem.flavorhub.data.source.network.usecase.recipes

import com.irem.flavorhub.data.local.RecipeDao
import com.irem.flavorhub.model.Recipe
import javax.inject.Inject

class DeleteRecipe  @Inject constructor(
    private val recipeDao: RecipeDao
) {
    suspend operator fun invoke(recipe: Recipe){
        recipeDao.delete(recipe = recipe)
    }

}