package com.mistpaag.moviesapp.presentation.detail.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun KeyValueTextScreen(key: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()){
        Surface {
            Text(text = key)
        }
        Surface {
            Text(text = value, color = Color.DarkGray)
        }
    }
}