package com.elongocrea.zmovie.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.elongocrea.zmovie.data.local.model.Movie
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface MovieDao {

    @Insert
    fun insert(movie: Movie): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<Movie>): Completable

    @Query("SELECT * FROM movies")
    fun getAll(): Flowable<List<Movie>>

    @Delete
    fun delete(movie: Movie)

    @Query("DELETE FROM movies")
    fun deleteAll(): Completable

    @Update
    fun update(movie: Movie)

}