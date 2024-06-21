package com.elongocrea.zmovie.ui.components.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.elongocrea.zmovie.data.local.model.Movie
import com.elongocrea.zmovie.ui.components.image.RoundedImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(movie: Movie, onClick: (Movie) -> Unit) {
    Column(modifier = Modifier
        .padding(8.dp)
        .clickable { onClick(movie) }) {
        movie.posterPath?.let { posterPath ->
            RoundedImage(
                image = rememberImagePainter("https://image.tmdb.org/t/p/w500$posterPath"),
                description = movie.title
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = movie.title, style = TextStyle(
            fontSize = TextUnit(value = 14f, type = TextUnitType.Sp),
            fontWeight = FontWeight.Bold
        ))
    }
}