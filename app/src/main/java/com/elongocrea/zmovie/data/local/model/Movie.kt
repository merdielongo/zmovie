package com.elongocrea.zmovie.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey val id: Int,
    val title: String,
    val overview: String,

    @SerializedName("release_date")
    @ColumnInfo(name = "release_date")
    val releaseDate: String? = null,

    @SerializedName("original_title")
    @ColumnInfo(name = "original_title")
    val originalTitle: String,

    @SerializedName("original_language")
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,

    val popularity: Double,

    @SerializedName("vote_average")
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,


    @SerializedName("vote_count")
    @ColumnInfo(name = "vote_count")
    val voteCount: Int,

    val adult: Boolean,


    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,


    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    val posterPath: String? = null,

    val video: Boolean,

    @SerializedName("genre_ids")
    val genreIds: List<Int>? = emptyList()
)
