package com.elongocrea.zmovie.data.repository

import com.elongocrea.zmovie.data.local.dao.MovieDao
import com.elongocrea.zmovie.data.local.model.Movie
import com.elongocrea.zmovie.data.remote.api.TheMovieDbApi
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

class MovieRepository(
    private val movieDao: MovieDao,
    private val api: TheMovieDbApi,
    private val apiKey: String
) {

    val all: Flowable<List<Movie>> = movieDao.getAll()

    fun create(movie: Movie) {
        movieDao.insert(movie)
    }

    fun delete(movie: Movie) {
        movieDao.delete(movie)
    }

    fun deleteAll() {
        movieDao.deleteAll()
    }

    fun fetchListFromApi(): Single<List<Movie>> {
        return api.getListPopular(apiKey).map { it.results }
    }

}