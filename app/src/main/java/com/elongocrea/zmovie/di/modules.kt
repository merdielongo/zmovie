package com.elongocrea.zmovie.di

import androidx.room.Room
import com.elongocrea.zmovie.auth.FirebaseAuthManager
import com.elongocrea.zmovie.data.local.AppDatabase
import com.elongocrea.zmovie.data.remote.api.TMDBClient
import com.elongocrea.zmovie.data.repository.MovieRepository
import com.elongocrea.zmovie.utils.Utils
import com.elongocrea.zmovie.viewmodel.AuthViewModel
import com.elongocrea.zmovie.viewmodel.MovieViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "zmovie")
            .build()
    }
    single { Utils() }
    single { TMDBClient.instance }
    single {
        val apiKey = "c9b0d90f44ae247a0d1c8fa00bf200fd"
        MovieRepository(
            context = androidContext(),
            movieDao = get<AppDatabase>().movieDao(),
            api = get(),
            apiKey = apiKey
        )
    }
    single { FirebaseAuthManager() }

    viewModel { AuthViewModel(authManager = get()) }
    viewModel { MovieViewModel(repository = get()) }
}
