package com.irem.flavorhub.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.irem.flavorhub.model.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(recipe: Recipe)

    @Delete
    suspend fun delete(recipe: Recipe)

    @Query("SELECT * FROM Recipe")
    fun getRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM Recipe WHERE sourceUrl=:url")
    suspend fun getRecipe(url: String): Recipe?

}
