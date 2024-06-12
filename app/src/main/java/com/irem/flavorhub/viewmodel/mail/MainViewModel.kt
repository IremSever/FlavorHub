package com.irem.flavorhub.viewmodel.mail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irem.flavorhub.domain.usecase.app_entry.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject
import androidx.compose.runtime.State
import com.irem.flavorhub.navigation.FlavorHubRoute
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

    private val _splashCondition = mutableStateOf(true)
    val splashCondition: State<Boolean> = _splashCondition

    private val _startDestination = mutableStateOf<FlavorHubRoute>(FlavorHubRoute.SPLASH)
    val startDestination: MutableState<FlavorHubRoute> = _startDestination

    init {
        viewModelScope.launch {
            appEntryUseCases.readAppEntry().collect { shouldStartFromHomeScreen ->
                _startDestination.value = if (shouldStartFromHomeScreen) {
                    FlavorHubRoute.HOME
                } else {
                    FlavorHubRoute.WELCOME
                }
                delay(1000)
                _splashCondition.value = false
            }
        }
    }
}