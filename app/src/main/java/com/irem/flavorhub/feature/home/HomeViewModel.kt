package com.irem.flavorhub.feature.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.irem.flavorhub.data.source.network.usecase.recipes.GetRecipes
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getRecipeUseCase: GetRecipes
): ViewModel() {
    var state = mutableStateOf(HomeState())
        private set

    val recipes = getRecipeUseCase(
        sources = listOf("recipes")
    ).cachedIn(viewModelScope)
}

