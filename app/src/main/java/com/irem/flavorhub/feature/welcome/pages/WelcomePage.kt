package com.irem.flavorhub.feature.welcome.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.irem.flavorhub.R
import com.irem.flavorhub.feature.welcome.WelcomeData
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.irem.flavorhub.feature.common.Dimension.mediumPadding
import com.irem.flavorhub.feature.common.Dimension.largePadding
import com.irem.flavorhub.ui.theme.FlavorHubTheme

@Composable
fun WelcomePage(
    modifier: Modifier = Modifier,
    welcomeData: WelcomeData,
) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f),
            painter = painterResource(id = welcomeData.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(mediumPadding))
        Text(
            modifier = Modifier.padding(horizontal = mediumPadding),
            text = welcomeData.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.purple_500)
        )
        Text(
            modifier = Modifier.padding(horizontal = largePadding),
            text = welcomeData.spot,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.purple_200)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePagePreview() {
    FlavorHubTheme {
        WelcomePage(
            welcomeData = WelcomeData(
                title = "Lorem Ipsum is simply dummy",
                spot = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                image = R.drawable.welcome1
            )
        )
    }
}