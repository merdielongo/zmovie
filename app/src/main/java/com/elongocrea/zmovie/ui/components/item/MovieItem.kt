package com.elongocrea.zmovie.ui.components.item

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.elongocrea.zmovie.data.local.model.Movie

@Composable
fun MovieItem(movie: Movie) {
    Column {
        Text(text = movie.title, style = MaterialTheme.typography.headlineSmall)
        Text(text = movie.overview, style = MaterialTheme.typography.bodySmall)
    }
}