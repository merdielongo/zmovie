package com.elongocrea.zmovie.ui.screen.movie

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.elongocrea.zmovie.ui.components.item.MovieItem
import com.elongocrea.zmovie.utils.toLiveData
import com.elongocrea.zmovie.viewmodel.MovieViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

@Composable
fun MovieListScreen(viewModel: MovieViewModel, disposables: CompositeDisposable) {

    val moviesState = viewModel.all
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .toLiveData(disposables)
        .observeAsState(initial = emptyList())

    val movies = moviesState.value

    LazyColumn {
        items(movies) { movie ->
            MovieItem(movie = movie)
        }
    }

}