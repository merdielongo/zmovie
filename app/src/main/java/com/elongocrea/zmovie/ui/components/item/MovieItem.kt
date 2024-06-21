package com.elongocrea.zmovie.ui.components.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.elongocrea.zmovie.data.local.model.Movie

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(movie: Movie, onClick: (Movie) -> Unit) {
    println(movie)
    Column(modifier = Modifier.padding(8.dp).clickable { onClick(movie) }) {
        movie.posterPath?.let { posterPath ->
            GlideImage(
                model = "https://image.tmdb.org/t/p/w500$posterPath",
                contentDescription = movie.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }
        Text(text = movie.title, style = MaterialTheme.typography.headlineSmall)
        Text(text = movie.overview, style = MaterialTheme.typography.bodySmall)
    }
}