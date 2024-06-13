package com.irem.flavorhub.feature.welcome
sealed class WelcomeEvent {
    data object SaveAppEntry: WelcomeEvent()
}