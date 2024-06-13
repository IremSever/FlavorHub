package com.irem.flavorhub.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.irem.flavorhub.data.local.RecipeDao
import com.irem.flavorhub.data.source.network.RecipeApiService
import com.irem.flavorhub.data.source.network.RecipeNetworkDataSource
import com.irem.flavorhub.data.source.network.SearchNetworkDataSource
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeApiService: RecipeApiService,
    private val recipeDao: RecipeDao
) : RecipeRepository {

    override fun getRecipes(): Flow<List<Recipe>> {
        return recipeDao.getRecipes()
    }

    override suspend fun upsertRecipe(recipe: Recipe) {
        recipeDao.upsert(recipe)
    }

    override suspend fun deleteRecipe(recipe: Recipe) {
        recipeDao.delete(recipe)
    }

    override fun getRecipePagingData(sources: List<String>): Flow<PagingData<Recipe>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                RecipeNetworkDataSource(recipeApiService, sources.joinToString(separator = ","))
            }
        ).flow
    }

    override fun searchRecipe(searchQuery: String, sources: List<String>): Flow<PagingData<Recipe>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNetworkDataSource(recipeApiService, searchQuery, sources.joinToString(separator = ","))
            }
        ).flow
    }

    override suspend fun getRecipe(url: String): Recipe? {
        return recipeDao.getRecipe(url)
    }
}
