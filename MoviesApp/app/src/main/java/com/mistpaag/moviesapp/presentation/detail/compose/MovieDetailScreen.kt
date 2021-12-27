package com.mistpaag.moviesapp.presentation.detail.compose

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mistpaag.domain.Movie
import com.mistpaag.imagemanager.getMediaURL
import com.mistpaag.imagemanager.getMediaURLBack
import com.mistpaag.moviesapp.ui.theme.OurAppTheme

@Composable
fun MovieDetailScreen(movie: Movie) {
    val configuration = LocalConfiguration.current
    OurAppTheme {
        Surface {
            when (configuration.orientation) {
                Configuration.ORIENTATION_LANDSCAPE -> {
                    LandsCapeDetailScreen(movie = movie, configuration = configuration)
                }
                else -> {
                    PortraitDetailScreen(movie = movie, configuration= configuration)
                }
            }
        }

    }
}

@Composable
fun PortraitDetailScreen(movie: Movie, configuration: Configuration){
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Surface {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    ImageScreen(movie.backdropPath.getMediaURLBack(), (configuration.screenHeightDp * 0.4).dp)
                    BorderedImageScreen(movie.posterPath.getMediaURL(), 240.dp)

                }
                Text(
                    text = movie.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                    ,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h5,
                )
                CompositionLocalProvider( LocalContentAlpha provides ContentAlpha.medium){
                    Text(
                        text = movie.overview,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                AttributesMovie(movie = movie)
            }
        }

    }
}

@Composable
fun AttributesMovie(movie: Movie){
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        with(movie){
            KeyValueTextScreen(key = "Original title: ", value = originalTitle)
            KeyValueTextScreen(key = "Release date: ", value = releaseDate)
            KeyValueTextScreen(key = "Original language: ", value = originalLanguage)
        }
    }
}

@Composable
fun LandsCapeDetailScreen(movie: Movie, configuration: Configuration){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(0.5f),
            contentAlignment = Alignment.Center
        ){
            ImageScreen(movie.backdropPath.getMediaURLBack(), configuration.screenHeightDp.dp)
            BorderedImageScreen(movie.posterPath.getMediaURL(), 240.dp)
        }


            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Surface {
                    Text(
                        text = movie.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                        ,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h5,
                    )
                }

                Surface {
                    Text(
                        text = movie.overview,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(16.dp),
                        color = Color.DarkGray
                    )
                }

                AttributesMovie(movie = movie)
            }


    }

}

