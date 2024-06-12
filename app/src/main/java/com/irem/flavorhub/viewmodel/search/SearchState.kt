package com.irem.flavorhub.viewmodel.search

import androidx.paging.PagingData
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val recipes: Flow<PagingData<Recipe>>? = null
)