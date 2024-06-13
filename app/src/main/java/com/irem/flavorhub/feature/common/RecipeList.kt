package com.irem.flavorhub.feature.common

import androidx.paging.LoadState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.irem.flavorhub.feature.common.Dimension.mediumPadding
import com.irem.flavorhub.feature.common.Dimension.xSmallPadding
import com.irem.flavorhub.feature.home.components.HomeRecipeCard
import com.irem.flavorhub.model.Recipe

@Composable
fun RecipeList(
    modifier: Modifier = Modifier,
    recipes: List<Recipe>,
    onClick: (Recipe) -> Unit
) {
    if (recipes.isEmpty()){
        EmptyScreen()
    }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(mediumPadding),
        contentPadding = PaddingValues(all = xSmallPadding)
    ) {
        items(
            count = recipes.size,
        ) {
            recipes[it]?.let { recipe ->
                HomeRecipeCard(recipe = recipe, onClick = { onClick(recipe) })
            }
        }
    }

}

@Composable
fun RecipeList(
    modifier: Modifier = Modifier,
    recipes: LazyPagingItems<Recipe>,
    onClick: (Recipe) -> Unit
) {

    val handlePagingResult = handlePagingResult(recipes)


    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            contentPadding = PaddingValues(all = xSmallPadding)
        ) {
            items(
                count = recipes.itemCount,
            ) {
                recipes[it]?.let { recipe ->
                    HomeRecipeCard(recipe = recipe, onClick = { onClick(recipe) })
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(articles: LazyPagingItems<Recipe>): Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen(error = error)
            false
        }

        else -> {
            true
        }
    }
}

@Composable
fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(mediumPadding)) {
        repeat(10) {
            ShimmerEffect(
                modifier = Modifier.padding(horizontal = mediumPadding)
            )
        }
    }
}