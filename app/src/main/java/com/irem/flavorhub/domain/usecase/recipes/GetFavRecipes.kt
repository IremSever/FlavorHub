package com.irem.flavorhub.domain.usecase.recipes

import com.irem.flavorhub.data.local.RecipeDao
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavRecipes @Inject constructor(
    private val recipeDao: RecipeDao
) {

    operator fun invoke(): Flow<List<Recipe>>{
        return recipeDao.getRecipes()
    }

}