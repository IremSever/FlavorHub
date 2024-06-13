package com.irem.flavorhub.feature.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irem.flavorhub.data.source.network.usecase.recipes.DeleteRecipe
import com.irem.flavorhub.data.source.network.usecase.recipes.GetFavRecipes
import com.irem.flavorhub.data.source.network.usecase.recipes.UpsertRecipe
import com.irem.flavorhub.model.Recipe
import com.irem.flavorhub.utils.UIComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getFavRecipes: GetFavRecipes,
    private val deleteRecipeUseCase: DeleteRecipe,
    private val upsertRecipeUseCase: UpsertRecipe
) : ViewModel() {

    var sideEffect by mutableStateOf<UIComponent?>(null)
        private set

    fun onEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.UpsertDeleteRecipe -> {
                viewModelScope.launch {
                    val recipe = getFavRecipes(event.recipe.sourceUrl)
                    if (recipe == null){
                        upsertRecipe(recipe = event.recipe)
                    }else{
                        deleteRecipe(recipe = event.recipe)
                    }
                }
            }
            is DetailEvent.RemoveSideEffect ->{
                sideEffect = null
            }
        }
    }

    private suspend fun deleteRecipe(recipe: Recipe) {
        deleteRecipeUseCase(recipe)
        sideEffect = UIComponent.Toast("Recipe deleted")
    }

    private suspend fun upsertRecipe(recipe: Recipe) {
        upsertRecipeUseCase(recipe)
        sideEffect = UIComponent.Toast("Recipe Inserted")
    }
}
