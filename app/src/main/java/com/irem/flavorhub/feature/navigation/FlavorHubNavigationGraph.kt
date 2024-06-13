package com.irem.flavorhub.feature.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.navigation.navigation
import com.irem.flavorhub.feature.recipe_navigator.RecipeNavigatorScreen
import com.irem.flavorhub.feature.welcome.WelcomeScreen
import com.irem.flavorhub.feature.welcome.WelcomeViewModel


//Compose ilginç noktası navigation graph devreye giriyor.composable componentleri tutan yer
//nav graph tutacak composeable fonksiyon olacak. composable ekranları çizecek

@Composable
fun FlavorHubNavigationGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = FlavorHubRoute.START_NAVIGATION.route,
            startDestination = FlavorHubRoute.WELCOME.route
        ) {
            composable(route = FlavorHubRoute.WELCOME.route) {
                val viewModel: WelcomeViewModel = hiltViewModel()
                WelcomeScreen(onEvent = viewModel::onEvent)
            }
        }
        navigation(
            route = FlavorHubRoute.RECIPE_NAVIGATION.route,
            startDestination = FlavorHubRoute.RECIPE_NAVIGATOR.route
        ) {
            composable(route = FlavorHubRoute.RECIPE_NAVIGATOR.route) {
                RecipeNavigatorScreen()
            }
        }
    }
}

