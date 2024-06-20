package com.elongocrea.zmovie.ui.components.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elongocrea.zmovie.data.local.model.Movie

@Composable
fun MovieItem(movie: Movie, onClick: (Movie) -> Unit) {
    Column(modifier = Modifier.padding(8.dp).clickable { onClick(movie) }) {
        Text(text = movie.title, style = MaterialTheme.typography.headlineSmall)
        Text(text = movie.overview, style = MaterialTheme.typography.bodySmall)
    }
}