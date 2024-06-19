package com.elongocrea.zmovie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elongocrea.zmovie.data.local.dao.MovieDao
import com.elongocrea.zmovie.data.local.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}