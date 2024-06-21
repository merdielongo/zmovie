package com.elongocrea.zmovie.data.remote.api

import com.elongocrea.zmovie.data.remote.response.MovieResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbApi {

    @GET("movie/popular")
    fun getListPopular(@Query("api_key") apiKey: String, @Query("page") page: Int): Single<MovieResponse>


}