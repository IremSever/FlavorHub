package com.irem.flavorhub.data.source.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.irem.flavorhub.model.Recipe

class SearchNetworkDataSource (
    private val recipeApiService: RecipeApiService,
    private val searchQuery: String,
    private val sources: String
) : PagingSource<Int, Recipe>() {

    override fun getRefreshKey(state: PagingState<Int, Recipe>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private var totalRecipeCount = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Recipe> {
        val page = params.key ?: 1
        return try {
            val recipeResponse = recipeApiService.getRecipe(sources = sources, page = page)
            totalRecipeCount += recipeResponse.recipes.size
            val recipes = recipeResponse.recipes.distinctBy { it.title }

            LoadResult.Page(
                data = recipes,
                nextKey = if (totalRecipeCount == recipes.size) null else page +1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}