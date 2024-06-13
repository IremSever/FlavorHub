package com.irem.flavorhub.feature.recipe_navigator

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.irem.flavorhub.R
import com.irem.flavorhub.model.Recipe
import com.irem.flavorhub.feature.detail.DetailScreen
import com.irem.flavorhub.feature.home.HomeScreen
import com.irem.flavorhub.feature.navigation.BottomNavigationItem
import com.irem.flavorhub.feature.navigation.FlavorHubNavigation
import com.irem.flavorhub.feature.search.SearchScreen
import com.irem.flavorhub.feature.navigation.FlavorHubRoute
import com.irem.flavorhub.feature.detail.DetailViewModel
import com.irem.flavorhub.feature.home.HomeViewModel
import com.irem.flavorhub.feature.search.SearchViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeNavigatorScreen() {
    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
            BottomNavigationItem(icon = R.drawable.ic_favorite, text = "Favorite"),
        )
    }
    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value

    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    selectedItem = when (backStackState?.destination?.route) {
        FlavorHubRoute.HOME.route -> 0
        FlavorHubRoute.SEARCH.route -> 1
        FlavorHubRoute.FAVORITE.route -> 2
        else -> 0
    }
    //hide nav bar detail screen
    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == FlavorHubRoute.HOME.route ||
                backStackState?.destination?.route == FlavorHubRoute.SEARCH.route ||
                backStackState?.destination?.route == FlavorHubRoute.FAVORITE.route
    }
    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        if (isBottomBarVisible) {
            FlavorHubNavigation(
                items = bottomNavigationItems,
                selectedItem = selectedItem,
                onItemClick = { index ->
                    when (index) {
                        0 -> navigateToTab(
                            navController = navController,
                            route = FlavorHubRoute.HOME.route
                        )
                        1 -> navigateToTab(
                            navController = navController,
                            route = FlavorHubRoute.SEARCH.route
                        )
                        2 -> navigateToTab(
                            navController = navController,
                            route = FlavorHubRoute.FAVORITE.route
                        )
                    }
                }
            )
        }
    }) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = FlavorHubRoute.HOME.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = FlavorHubRoute.HOME.route) { backStackEntry ->
                val viewModel: HomeViewModel = hiltViewModel()
                val recipes = viewModel.recipes.collectAsLazyPagingItems()
                HomeScreen(
                    recipes = recipes,
                    navigateToSearch = {
                        navigateToTab(
                            navController = navController,
                            route = FlavorHubRoute.SEARCH.route
                        )
                    },
                    navigateToDetails = { recipe ->
                        navigateToDetails(
                            navController = navController,
                            recipe = recipe
                        )
                    }
                )
            }
            composable(route = FlavorHubRoute.SEARCH.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                val state = viewModel.state.value
                val event = viewModel::onEvent
                val navigateToDetails = { recipe: Recipe ->
                    navigateToDetails(
                        navController = navController,
                        recipe = recipe
                    )
                }
                OnBackClickStateSaver(navController = navController)
                SearchScreen(
                    state = state,
                    event = event,
                    navigateToDetails = navigateToDetails
                )
            }
            composable(route = FlavorHubRoute.DETAIL.route) {
                val viewModel: DetailViewModel = hiltViewModel()
                val sideEffect = viewModel.sideEffect
                navController.previousBackStackEntry?.savedStateHandle?.get<Recipe?>("detail")
                    ?.let { recipe ->
                        DetailScreen(
                            recipe = recipe,
                            event = {},
                            navigateUp = { navController.navigateUp() },
                            sideEffect = sideEffect
                        )
                    }
            }
            composable(route = FlavorHubRoute.FAVORITE.route) {
            }
        }
    }
}

@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        navigateToTab(
            navController = navController,
            route = FlavorHubRoute.HOME.route
        )
    }
}
private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screen_route ->
            popUpTo(screen_route) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}
private fun navigateToDetails(navController: NavController, recipe: Recipe) {
    navController.currentBackStackEntry?.savedStateHandle?.set("recipe", recipe)
    navController.navigate(
        route = FlavorHubRoute.DETAIL.route
    )
}