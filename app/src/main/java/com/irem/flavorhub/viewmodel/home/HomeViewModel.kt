package com.irem.flavorhub.viewmodel.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.irem.flavorhub.domain.usecase.recipes.RecipeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val recipeUseCases: RecipeUseCases
): ViewModel() {

    var state = mutableStateOf(HomeState())
        private set

    val recipe = recipeUseCases.getRecipes(
        sources = listOf("spoonacular")
    ).cachedIn(viewModelScope)

}