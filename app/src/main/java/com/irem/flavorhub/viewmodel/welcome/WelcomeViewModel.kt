package com.irem.flavorhub.viewmodel.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irem.flavorhub.domain.usecase.app_entry.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
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
            appEntryUseCases.saveAppEntry()
        }
    }

}