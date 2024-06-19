package com.elongocrea.zmovie

import android.app.Application
import androidx.room.Room
import com.elongocrea.zmovie.data.local.AppDatabase
import com.elongocrea.zmovie.data.remote.api.TMDBClient
import com.elongocrea.zmovie.data.repository.MovieRepository

class MyApplication : Application() {

    lateinit var database: AppDatabase
    lateinit var repository: MovieRepository

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "movie_database"
        ).build()

        repository = MovieRepository(
            movieDao = database.movieDao(),
            api = TMDBClient.instance,
            apiKey = "c9b0d90f44ae247a0d1c8fa00bf200fd"
        )
    }

}