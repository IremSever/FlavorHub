package com.irem.flavorhub.feature.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irem.flavorhub.data.source.network.usecase.app_entry.SaveAppEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val saveAppEntry: SaveAppEntry
) : ViewModel() {

    fun onEvent(event: WelcomeEvent){
        when(event){
            is WelcomeEvent.SaveAppEntry ->{
                saveUserEntry()
            }
        }
    }
    private fun saveUserEntry() {
        viewModelScope.launch {
            saveAppEntry()
        }
    }

}