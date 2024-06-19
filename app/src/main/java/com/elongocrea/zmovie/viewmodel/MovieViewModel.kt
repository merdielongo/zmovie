package com.elongocrea.zmovie.viewmodel

import androidx.lifecycle.ViewModel
import com.elongocrea.zmovie.data.local.model.Movie
import com.elongocrea.zmovie.data.repository.MovieRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
    private val disposables = CompositeDisposable()

    val all: Flowable<List<Movie>> = repository.all

    fun create(movie: Movie) {
        repository.create(movie)
    }

    fun delete(movie: Movie) {
        repository.delete(movie)
    }

    fun deleteAll() {
        repository.deleteAll()
    }

    fun fetchMoviesFromApi(): Single<List<Movie>> {
        return repository.fetchListFromApi()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}