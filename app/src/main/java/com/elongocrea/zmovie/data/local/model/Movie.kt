package com.elongocrea.zmovie.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = false) val id: Int,
    @ColumnInfo(name = "web_id")
    val webId: Int,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val posterPath: String?
)