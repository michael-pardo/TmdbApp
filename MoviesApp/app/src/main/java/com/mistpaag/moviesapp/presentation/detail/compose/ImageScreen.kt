package com.mistpaag.moviesapp.presentation.detail.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ImageScreen(url: String, imageSize: Dp) {
    Card(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        elevation = 4.dp,
    ) {
        Image(
            painter = rememberImagePainter(
                url,
            ),
            contentDescription = "Content description",
            modifier = Modifier.size(height = imageSize, width = 0.dp),
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun BorderedImageScreen(url: String, imageSize: Dp) {
    Card(
        modifier = Modifier.padding(16.dp)
            .clip(RoundedCornerShape(8.dp)),
        elevation = 8.dp,
    ) {
        Image(
            painter = rememberImagePainter(
                url,
            ),
            contentDescription = "Content description",
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Crop,
        )
    }
}