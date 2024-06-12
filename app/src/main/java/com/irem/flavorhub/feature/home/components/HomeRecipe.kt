package com.irem.flavorhub.feature.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.irem.flavorhub.model.Recipe
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.irem.flavorhub.R
import com.irem.flavorhub.feature.Dimension.homeCardPadding
import com.irem.flavorhub.feature.Dimension.smallPadding
import com.irem.flavorhub.feature.Dimension.xSmallPadding
import com.irem.flavorhub.ui.theme.FlavorHubTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.irem.flavorhub.ui.theme.Purple40
import com.irem.flavorhub.ui.theme.Purple80
import com.irem.flavorhub.ui.theme.PurpleGrey80

@Composable
fun HomeRecipe(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    onClick: (() -> Unit)? = null
) {
    val context = LocalContext.current
    Row(
        modifier = modifier.clickable { onClick?.invoke() },
    ) {
        AsyncImage(
            modifier = Modifier
                .size(homeCardPadding)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(recipe.image).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = smallPadding)
                .height(homeCardPadding)
        ) {
            Text(
                text = recipe.title ?: "",
                style = MaterialTheme.typography.bodyMedium.copy(),
                color = Purple40,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = recipe.sourceName ?: "",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = Purple80
                )
                Spacer(modifier = Modifier.width(xSmallPadding))
                Icon(
                    //buraya bak
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = null,
                    modifier = Modifier.size(smallPadding),
                    tint = PurpleGrey80
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeRecipePreview() {
    FlavorHubTheme(dynamicColor = false) {
        HomeRecipe(
            recipe = Recipe(
                aggregateLikes = null,
                analyzedInstructions = null,
                cheap = null,
                cookingMinutes = null,
                creditsText = null,
                cuisines = null,
                dairyFree = null,
                diets = null,
                dishTypes = null,
                extendedIngredients = null,
                gaps = null,
                glutenFree = null,
                healthScore = null,
                id = null,
                image = "",
                imageType = null,
                instructions = null,
                license = null,
                lowFodmap = null,
                occasions = null,
                originalId = null,
                preparationMinutes = null,
                pricePerServing = null,
                readyInMinutes = null,
                servings = null,
                sourceName = "",
                sourceUrl = "",
                spoonacularScore = null,
                spoonacularSourceUrl = null,
                summary = "",
                sustainable = null,
                title = "",
                vegan = null,
                vegetarian = null,
                veryHealthy = null,
                veryPopular = null,
                weightWatcherSmartPoints = null,
            )
        )
    }
}