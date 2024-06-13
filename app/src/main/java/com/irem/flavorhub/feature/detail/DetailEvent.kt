package com.irem.flavorhub.feature.detail

import com.irem.flavorhub.model.Recipe

sealed class DetailEvent {
    data class UpsertDeleteRecipe(val recipe: Recipe) : DetailEvent()
    object RemoveSideEffect : DetailEvent()
}