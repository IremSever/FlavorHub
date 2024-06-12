package com.irem.flavorhub.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.irem.flavorhub.feature.common.Dimension.mediumPadding
import com.irem.flavorhub.feature.common.RecipeList
import com.irem.flavorhub.feature.common.RecipeSearchBar
import com.irem.flavorhub.model.Recipe
import com.irem.flavorhub.viewmodel.search.SearchEvent
import com.irem.flavorhub.viewmodel.search.SearchState


@Composable
fun SearchScreen(
    state: SearchState,
    event:(SearchEvent) -> Unit,
    navigateToDetails:(Recipe) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(top = mediumPadding, start = mediumPadding, end = mediumPadding)
            .statusBarsPadding()
    ) {
        RecipeSearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = {
                event(SearchEvent.SearchRecipe)
            }
        )
        Spacer(modifier = Modifier.height(mediumPadding))
        state.recipes?.let {
            val recipes = it.collectAsLazyPagingItems()
            RecipeList(
                recipes = recipes,
                onClick = navigateToDetails
            )
        }
    }
}