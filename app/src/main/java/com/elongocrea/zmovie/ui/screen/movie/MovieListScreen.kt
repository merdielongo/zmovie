package com.elongocrea.zmovie.ui.screen.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.elongocrea.zmovie.ui.components.item.MovieItem
import com.elongocrea.zmovie.utils.toLiveData
import com.elongocrea.zmovie.viewmodel.MovieViewModel
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieListScreen(
    navController: NavHostController,
    movieViewModel: MovieViewModel = koinViewModel(),
    disposables: CompositeDisposable
) {

    movieViewModel.fetchMoviesFromApi()
    val movies = movieViewModel.movies.observeAsState(initial = emptyList())

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(movies.value) { movie ->
            MovieItem(movie = movie) {
                val movieJson = Gson().toJson(movie)
                println(movieJson)
                // navController.navigate("movie_detail/${movie.id}")
            }
        }
    }

}