package com.irem.flavorhub.viewmodel.favorite

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.irem.flavorhub.domain.usecase.recipes.GetFavRecipes
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteRecipe: GetFavRecipes
) : ViewModel() {

    private val _state = mutableStateOf(FavoriteState())
    val state: State<FavoriteState> = _state

    init {
        getRecipe()
    }

    private fun getRecipe() {
        getFavoriteRecipe().onEach {
            _state.value = _state.value.copy(recipe = it)
        }.launchIn(viewModelScope)
    }
}