package com.irem.flavorhub.model

import com.irem.flavorhub.model.Equipment
import com.irem.flavorhub.model.Ingredient
import com.irem.flavorhub.model.Length

data class Step(
    val equipment: List<Equipment>,
    val ingredients: List<Ingredient>,
    val length: Length,
    val number: Int,
    val step: String
)