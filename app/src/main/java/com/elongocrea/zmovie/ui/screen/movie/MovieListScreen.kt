package com.elongocrea.zmovie.ui.screen.movie

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
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

    val moviesState = movieViewModel.all
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .toLiveData(disposables)
        .observeAsState(initial = emptyList())

    val movies = moviesState.value

    LazyColumn {
        items(movies) { movie ->
            MovieItem(movie = movie) {
                val movieJson = Gson().toJson(movie)
                println(movieJson)
                // navController.navigate("movie_detail/${movie.id}")
            }
        }
    }

}