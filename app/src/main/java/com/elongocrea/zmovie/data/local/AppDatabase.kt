package com.elongocrea.zmovie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.elongocrea.zmovie.data.local.converters.ListIntConvert
import com.elongocrea.zmovie.data.local.dao.MovieDao
import com.elongocrea.zmovie.data.local.model.Movie

@Database(entities = [Movie::class], version = 1)
@TypeConverters(ListIntConvert::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}