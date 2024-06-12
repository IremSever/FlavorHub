package com.irem.flavorhub.feature.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.irem.flavorhub.model.Recipe
import com.irem.flavorhub.viewmodel.detail.DetailEvent
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.irem.flavorhub.R
import com.irem.flavorhub.feature.Dimension.recipeImageHeight
import com.irem.flavorhub.feature.common.Dimension.mediumPadding
import com.irem.flavorhub.feature.detail.component.DetailTopBar

@Composable
fun DetailScreen(
    recipe: Recipe,
    event: (DetailEvent) -> Unit,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().statusBarsPadding()) {
        DetailTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(recipe.sourceUrl ?: "")
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, recipe.sourceUrl ?: "")
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onFavoriteClick = {
                event(DetailEvent.SaveDetail)
            },
            onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = mediumPadding,
                end = mediumPadding,
                top = mediumPadding
            )
        ) {
            item {
                recipe.image?.let { imageUrl ->
                    AsyncImage(
                        model = ImageRequest.Builder(context = context).data(imageUrl)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(recipeImageHeight)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(mediumPadding))
                Text(
                    text = recipe.title ?: "",
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(
                        id = R.color.purple_700
                    )
                )
                Text(
                    text = recipe.summary ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(
                        id = R.color.purple_700
                    )
                )
            }
        }
    }
}