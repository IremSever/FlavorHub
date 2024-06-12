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

class RecipeRepositoryImpl(
    private val recipeApi: RecipeApiService,
    private val recipeDao: RecipeDao
): RecipeRepository {
    override fun getRecipe(sources: List<String>): Flow<PagingData<Recipe>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                RecipeNetworkDataSource(recipeApi = recipeApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }

    override fun searchRecipe(searchQuery: String, sources: List<String>): Flow<PagingData<Recipe>> {
        TODO()
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNetworkDataSource()
            }
        ).flow
    }

   override suspend fun upsertRecipe(recipe: Recipe) {
        recipeDao.upsert(recipe)
    }

    override suspend fun deleteArticle(recipe: Recipe) {
        recipeDao.delete(recipe)
    }

    override fun getRecipe(): Flow<List<Recipe>> {
        return recipeDao.getRecipe()
    }

}
