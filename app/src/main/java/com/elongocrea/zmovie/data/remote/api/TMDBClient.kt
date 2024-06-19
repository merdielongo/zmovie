package com.elongocrea.zmovie.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TMDBClient {

    private const val BASE_URL = "https://api.themoviedb.org/3"

    val instance: TheMovieDbApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(TheMovieDbApi::class.java)
    }

}