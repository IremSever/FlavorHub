package com.irem.flavorhub.data.source.network

import com.irem.flavorhub.data.source.network.response.RecipeResponse
import com.irem.flavorhub.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApiService {
    @GET("everything")
    suspend fun getRecipe(
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): RecipeResponse

    @GET("everything")
    suspend fun searchRecipe(
        @Query("q") searchQuery: String,
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): RecipeResponse
}