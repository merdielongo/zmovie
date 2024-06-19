package com.elongocrea.zmovie.data.remote.response

import com.elongocrea.zmovie.data.local.model.Movie

data class MovieResponse (
    val results: List<Movie>
)