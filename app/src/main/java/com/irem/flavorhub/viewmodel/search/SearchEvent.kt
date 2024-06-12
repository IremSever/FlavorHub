package com.irem.flavorhub.viewmodel.search

sealed class SearchEvent {
    data class UpdateSearchQuery(val searchQuery: String) : SearchEvent()
    object SearchRecipe : SearchEvent()
}