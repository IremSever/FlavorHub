package com.irem.flavorhub.feature.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject
import androidx.compose.runtime.State
import com.irem.flavorhub.data.source.network.usecase.app_entry.ReadAppEntry
import com.irem.flavorhub.feature.navigation.FlavorHubRoute
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val readAppEntry: ReadAppEntry
): ViewModel() {

    private val _splashCondition = mutableStateOf(true)
    val splashCondition: State<Boolean> = _splashCondition

    private val _startDestination = mutableStateOf(FlavorHubRoute.START_NAVIGATION.route)
    val startDestination: State<String> = _startDestination


    init {
        readAppEntry().onEach { shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                _startDestination.value = FlavorHubRoute.RECIPE_NAVIGATION.route
            }else{
                _startDestination.value = FlavorHubRoute.START_NAVIGATION.route
            }
            delay(1000)
            _splashCondition.value = false
        }.launchIn(viewModelScope)
    }
}
