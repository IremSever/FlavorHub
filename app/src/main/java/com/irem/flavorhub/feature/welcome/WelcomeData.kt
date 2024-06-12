package com.irem.flavorhub.feature.welcome

import androidx.annotation.DrawableRes
import com.irem.flavorhub.R


data class WelcomeData(
    val title:String,
    val spot:String,
    @DrawableRes val image: Int
)

val pages = listOf(
    WelcomeData(
        title = "Flavor Exploration",
        spot = "Elevate your dining experience with our recipe app. Welcome to a world of culinary delights at your fingertips!",
        image = R.drawable.welcome1
    ),
    WelcomeData(
        title = "Flavor Exploration",
        spot = " Dive into a world of flavors waiting to be explored with our recipe app. Discover new tastes and culinary adventures right at your fingertips.",
        image = R.drawable.welcome2
    ),
    WelcomeData(
        title = "Effortless Gourmet",
        spot = "Elevate your dining experience effortlessly with our recipe app.Let's make every mealtime extraordinary.",
        image = R.drawable.welcome3
    ),
)
