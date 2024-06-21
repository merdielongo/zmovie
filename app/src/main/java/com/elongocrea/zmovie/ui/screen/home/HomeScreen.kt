package com.elongocrea.zmovie.ui.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.elongocrea.zmovie.ui.components.item.MovieItem
import com.elongocrea.zmovie.viewmodel.MovieViewModel
import com.google.gson.Gson
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
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