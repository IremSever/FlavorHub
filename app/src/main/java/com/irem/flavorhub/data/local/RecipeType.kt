package com.irem.flavorhub.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.irem.flavorhub.model.Recipe

@ProvidedTypeConverter
class RecipeType {
    @TypeConverter
    fun sourceToString(recipe: Recipe): String{
        return "${recipe.id},${recipe.title ?: ""}"
    }

    @TypeConverter
    fun stringToSource(recipe: String): Recipe{
        val parts = recipe.split(',')
        return Recipe(
            id = parts[0],
            title = if (parts.size > 1) parts[1] else null,
            aggregateLikes = null,
            analyzedInstructions = null,
            cheap = null,
            cookingMinutes = null,
            creditsText = null,
            cuisines = null,
            dairyFree = null,
            diets = null,
            dishTypes = null,
            extendedIngredients = null,
            gaps = null,
            glutenFree = null,
            healthScore = null,
            image = null,
            imageType = null,
            instructions = null,
            license = null,
            lowFodmap = null,
            occasions = null,
            originalId = null,
            preparationMinutes = null,
            pricePerServing = null,
            readyInMinutes = null,
            servings = null,
            sourceName = null,
            sourceUrl = null,
            spoonacularScore = null,
            spoonacularSourceUrl = null,
            summary = null,
            sustainable = null,
            vegan = null,
            vegetarian = null,
            veryHealthy = null,
            veryPopular = null,
            weightWatcherSmartPoints = null
        )
    }
}