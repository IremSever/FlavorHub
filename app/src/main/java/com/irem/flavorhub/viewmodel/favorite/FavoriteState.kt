package com.irem.flavorhub.viewmodel.favorite

import com.irem.flavorhub.model.Recipe
data class FavoriteState(
    val recipe: List<Recipe> = emptyList()
)
