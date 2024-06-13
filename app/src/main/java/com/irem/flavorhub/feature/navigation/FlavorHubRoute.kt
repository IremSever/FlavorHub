package com.irem.flavorhub.feature.navigation

import androidx.navigation.NamedNavArgument

sealed class FlavorHubRoute(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    object WELCOME: FlavorHubRoute(route = "welcome")
    object HOME: FlavorHubRoute(route = "home")
    object SEARCH: FlavorHubRoute(route = "search")
    object FAVORITE: FlavorHubRoute(route = "favorite")
    object DETAIL: FlavorHubRoute(route = "detail")
    object START_NAVIGATION: FlavorHubRoute(route = "start_navigation")
    object RECIPE_NAVIGATION: FlavorHubRoute(route = "recipe_navigation")
    object RECIPE_NAVIGATOR: FlavorHubRoute(route = "recipe_navigator")
}
