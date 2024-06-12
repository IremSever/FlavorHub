package com.irem.flavorhub.feature.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.irem.flavorhub.R
import com.irem.flavorhub.feature.common.Dimension.mediumPadding
import com.irem.flavorhub.feature.common.RecipeList
import com.irem.flavorhub.model.Recipe
import com.irem.flavorhub.viewmodel.favorite.FavoriteState

@Composable
fun FavoriteScreen(
        state: FavoriteState,
        navigateToDetails: (Recipe) -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(top = mediumPadding, start = mediumPadding, end = mediumPadding)
        ) {

            Text(
                text = "Favorite",
                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
                color = colorResource(
                    id = R.color.purple_700
                )
            )

            Spacer(modifier = Modifier.height(mediumPadding))

            RecipeList(
                recipes = state.recipe,
                onClick = navigateToDetails
            )
        }
    }