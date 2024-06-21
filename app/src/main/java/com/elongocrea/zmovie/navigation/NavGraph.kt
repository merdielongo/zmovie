package com.elongocrea.zmovie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elongocrea.zmovie.ui.screen.auth.LoginScreen
import com.elongocrea.zmovie.ui.screen.movie.MovieListScreen
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = "movies",
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("login") {
            LoginScreen(navController = navController)
        }

        composable("movies") {
            val disposables = CompositeDisposable()
            MovieListScreen(navController = navController, disposables = disposables)
        }
//        composable("movie_detail/{movie}") { backStackEntry ->
//            val movieJson = backStackEntry.arguments?.getString("movie")
//            val movie = Gson().fromJson(movieJson, Movie::class.java)
//            MovieDetailScreen(movie = movie)
//        }
    }

}