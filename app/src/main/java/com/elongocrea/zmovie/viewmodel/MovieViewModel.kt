package com.elongocrea.zmovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elongocrea.zmovie.data.local.model.Movie
import com.elongocrea.zmovie.data.repository.MovieRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
    private val disposables = CompositeDisposable()

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies


    fun create(movie: Movie) {
        repository.create(movie)
    }

    fun delete(movie: Movie) {
        repository.delete(movie)
    }

    fun deleteAll() {
        repository.deleteAll()
    }

    fun fetchMoviesFromApi() {
        val disposable = repository.getList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movies ->
                _movies.postValue(movies)
            }, { error ->
                // Handle error
                error.printStackTrace()
            })
        this.disposables.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}