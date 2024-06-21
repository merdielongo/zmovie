package com.elongocrea.zmovie.data.repository

import android.util.Log
import com.elongocrea.zmovie.data.local.dao.MovieDao
import com.elongocrea.zmovie.data.local.model.Movie
import com.elongocrea.zmovie.data.remote.api.TheMovieDbApi
import com.elongocrea.zmovie.utils.Utils
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import android.content.Context

class MovieRepository(
    private val context: Context,
    private val movieDao: MovieDao,
    private val api: TheMovieDbApi,
    private val apiKey: String
) {

    private val compositeDisposable = CompositeDisposable()


    fun getList(): Single<List<Movie>> {
        checkAndFetchRemoteMovies()
        return movieDao.getAll()
    }

    fun getListMerge(): Flowable<List<Movie>> {
        return movieDao.getAll()
            .mergeWith(getListRemoteMovies())
    }

    private fun getListRemoteMovies(): Single<List<Movie>> {
        return api.getListPopular(apiKey, 1)
            .map { response -> response.results }
            .flatMap { movies ->
                movieDao.deleteAll()
                    .andThen(movieDao.insertAll(movies))
                    .andThen(Single.just(movies))
            }
            .doOnError { error ->
                Log.e("MovieRepository", "Error fetching movies", error)
                error.printStackTrace()
            }
            .subscribeOn(Schedulers.io())
    }

    fun create(movie: Movie) {
        compositeDisposable.add(
            Single.fromCallable { movieDao.insert(movie) }
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { /* Gérer le succès */ },
                    { error -> error.printStackTrace() }
                )
        )
    }

    fun delete(movie: Movie) {
        compositeDisposable.add(
            Single.fromCallable { movieDao.delete(movie) }
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { /* Gérer le succès */ },
                    { error -> error.printStackTrace() }
                )
        )
    }

    fun deleteAll() {
        compositeDisposable.add(
            Single.fromCallable { movieDao.deleteAll() }
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { /* Gérer le succès */ },
                    { error -> error.printStackTrace() }
                )
        )
    }

    fun fetchListFromApi(page: Int): Single<List<Movie>> {
        return api.getListPopular(apiKey, page).map { it.results }
            .subscribeOn(Schedulers.io())
    }

    fun clear() {
        compositeDisposable.clear()
    }

    private fun checkAndFetchRemoteMovies() {
        if (Utils.isNetworkAvailable(context)) {
            compositeDisposable.add(
                getListRemoteMovies()
                    .subscribe(
                        { movies ->
                            Log.d("MovieRepository", "Movies updated from remote $movies")
                        },
                        { error ->
                            Log.e("MovieRepository", "Error updating movies from remote", error)
                        }
                    )
            )
        }
    }
}
