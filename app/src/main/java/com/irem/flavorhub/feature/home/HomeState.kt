package com.irem.flavorhub.feature.home

data class HomeState(
    val recipeTicker: String = "",
    val isLoading: Boolean = false,
)