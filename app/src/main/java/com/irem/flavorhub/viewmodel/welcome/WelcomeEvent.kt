package com.irem.flavorhub.viewmodel.welcome

sealed class WelcomeEvent {
    data object SaveAppEntry: WelcomeEvent()

}