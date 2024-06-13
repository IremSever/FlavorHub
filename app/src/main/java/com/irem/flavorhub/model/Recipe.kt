package com.irem.flavorhub.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlin.collections.List

@Parcelize
@Entity
data class Recipe(
    val aggregateLikes: Int?,
    val creditsText: String?,
    val dairyFree: Boolean?,
    val gaps: String?,
    val glutenFree: Boolean?,
    val healthScore: Int?,
    @PrimaryKey val id: String,
    val image: String?,
    val imageType: String?,
    val instructions: String?,
    val license: String?,
    val lowFodmap: Boolean?,
    val pricePerServing: Double?,
    val readyInMinutes: Int?,
    val servings: Int?,
    val sourceName: String?,
    val sourceUrl: String?,
    val spoonacularScore: Double?,
    val spoonacularSourceUrl: String?,
    val summary: String?,
    val sustainable: Boolean?,
    val title: String?,
    val vegan: Boolean?,
    val vegetarian: Boolean?,
    val veryHealthy: Boolean?,
    val veryPopular: Boolean?,
    val weightWatcherSmartPoints: Int?
) : Parcelable