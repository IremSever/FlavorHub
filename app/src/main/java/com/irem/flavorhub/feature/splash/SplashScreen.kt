package com.irem.flavorhub.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.irem.flavorhub.R
import com.irem.flavorhub.ui.theme.Purple40
import com.irem.flavorhub.ui.theme.PurpleGrey40
import com.irem.flavorhub.ui.theme.PurpleGrey80
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished:() -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2000)
        onSplashFinished()

    }

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

