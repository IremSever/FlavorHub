package com.irem.flavorhub.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.irem.flavorhub.data.RecipeRepository
import com.irem.flavorhub.data.RecipeRepositoryImpl
import com.irem.flavorhub.data.local.RecipeDao
import com.irem.flavorhub.data.source.network.RecipeApiService
import com.irem.flavorhub.navigation.FlavorHubNavigationGraph
import com.irem.flavorhub.ui.theme.FlavorHubTheme
import com.irem.flavorhub.viewmodel.mail.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity(private val recipeApiService: RecipeApiService, private val recipeDao: RecipeDao) : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var repository: RecipeRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        repository = RecipeRepositoryImpl(
            recipeApiService = recipeApiService,
            recipeDao = recipeDao
        )


        setContent {
            FlavorHubTheme(dynamicColor = false) {
                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemUiColor = rememberSystemUiController()
                SideEffect {
                    systemUiColor.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }

                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxSize()) {
                    FlavorHubNavigationGraph(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}
