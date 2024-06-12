package com.irem.flavorhub.navigation

import androidx.navigation.NamedNavArgument

sealed class FlavorHubRoute(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object SPLASH: FlavorHubRoute(route = "splash")
    data object WELCOME: FlavorHubRoute(route = "welcome")
    data object HOME: FlavorHubRoute(route = "home")
    data object SEARCH: FlavorHubRoute(route = "search")
    data object FAVORITE: FlavorHubRoute(route = "favorite")
    data object DETAIL: FlavorHubRoute(route = "detail")
    data object START_NAVIGATION: FlavorHubRoute(route = "start_navigation")
    data object RECIPE_NAVIGATION: FlavorHubRoute(route = "recipe_navigation")
    data object RECIPE_NAVIGATOR: FlavorHubRoute(route = "recipe_navigator")
}
