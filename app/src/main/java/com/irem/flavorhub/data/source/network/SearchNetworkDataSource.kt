package com.irem.flavorhub.data.source.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.irem.flavorhub.model.Recipe
import java.lang.Exception

class SearchNetworkDataSource (
    private val recipeApiService: RecipeApiService,
    private val searchQuery: String,
    private val sources: String
) : PagingSource<Int, Recipe>() {

    override fun getRefreshKey(state: PagingState<Int, Recipe>): Int? {
        return state.anchorPosition?.let { anchorPage ->
            val page = state.closestPageToPosition(anchorPage)
            page?.nextKey?.minus(1) ?: page?.prevKey?.plus(1)
        }
    }

    private var totalSearchCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Recipe> {
        val page = params.key ?: 1
        return try {
            val recipeResponse = recipeApiService.searchRecipe(searchQuery = searchQuery, sources = sources, page = page)
            totalSearchCount += recipeResponse.recipes.size
            val recipes = recipeResponse.recipes.distinctBy { it.title } //Remove duplicates

            LoadResult.Page(
                data = recipes,
                nextKey = if (totalSearchCount == recipeResponse.recipes.size) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }
}