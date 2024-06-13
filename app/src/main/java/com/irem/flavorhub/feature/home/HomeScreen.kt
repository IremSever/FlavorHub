package com.irem.flavorhub.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.irem.flavorhub.R
import com.irem.flavorhub.model.Recipe
import com.irem.flavorhub.feature.common.Dimension.mediumPadding
import com.irem.flavorhub.feature.common.RecipeList
import com.irem.flavorhub.feature.common.RecipeSearchBar

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun HomeScreen(
    recipes: LazyPagingItems<Recipe>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Recipe) -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (recipes.itemCount > 10) {
                recipes.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title.toString() }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = mediumPadding)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = mediumPadding)
        )

        Spacer(modifier = Modifier.height(mediumPadding))

        RecipeSearchBar(
            modifier = Modifier
                .padding(horizontal = mediumPadding)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = navigateToSearch
        )

        Spacer(modifier = Modifier.height(mediumPadding))

        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = mediumPadding)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.purple_200)
        )

        Spacer(modifier = Modifier.height(mediumPadding))

        RecipeList(
            modifier = Modifier.padding(horizontal = mediumPadding),
            recipes = recipes,
            onClick = navigateToDetails
        )
    }
}