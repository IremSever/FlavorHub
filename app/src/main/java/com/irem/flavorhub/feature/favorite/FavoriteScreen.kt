package com.irem.flavorhub.feature.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.irem.flavorhub.R
import com.irem.flavorhub.ui.theme.Purple40

@Composable
fun FavoriteScreen() {
    //center of text
    Scaffold(
        containerColor = Purple40
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )
        }
    }
}
