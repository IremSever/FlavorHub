package com.irem.flavorhub.feature.favorite

import com.irem.flavorhub.model.Recipe

data class FavoriteState(
    val recipes: List<Recipe> = emptyList()
)
