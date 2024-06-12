package com.irem.flavorhub.data.local

import androidx.room.Database
import androidx.room.TypeConverters
import com.irem.flavorhub.model.Recipe

@Database(entities = [Recipe::class],version = 1,)
@TypeConverters(RecipeType::class)
abstract class RecipeDatabase {
    abstract val recipeDao: RecipeDao
}