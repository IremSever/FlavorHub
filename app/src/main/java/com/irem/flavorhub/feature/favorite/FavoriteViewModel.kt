package com.irem.flavorhub.feature.favorite

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.irem.flavorhub.data.source.network.usecase.recipes.GetFavRecipes
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavRecipes: GetFavRecipes
) : ViewModel() {

    private val _state = mutableStateOf(FavoriteState())
    val state: State<FavoriteState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        getFavRecipes().onEach {
            _state.value = _state.value.copy(recipes = it)
        }.launchIn(viewModelScope)
    }
}