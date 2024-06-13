package com.irem.flavorhub.viewmodel.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.irem.flavorhub.data.local.RecipeDao
import com.irem.flavorhub.domain.usecase.recipes.GetRecipes
import com.irem.flavorhub.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getNewsUseCase: GetRecipes
): ViewModel() {

    var state = mutableStateOf(HomeState())
        private set

    val recipes = getNewsUseCase(
        sources = listOf("recipe")
    ).cachedIn(viewModelScope)

}

