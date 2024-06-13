package com.irem.flavorhub.viewmodel.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.State
import androidx.paging.cachedIn
import com.irem.flavorhub.domain.usecase.recipes.SearchRecipe
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRecipe: SearchRecipe
) : ViewModel() {

    private var _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state


    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.UpdateSearchQuery -> {
                _state.value = _state.value.copy(searchQuery = event.searchQuery)
            }

            is SearchEvent.SearchRecipe -> {
                searchRecipe()
            }
        }
    }

    private fun searchRecipe() {
        val recipes = searchRecipe(
            searchQuery = _state.value.searchQuery,
            sources = listOf("recipe")
        ).cachedIn(viewModelScope)
        _state.value = _state.value.copy(recipes = recipes)
    }


}