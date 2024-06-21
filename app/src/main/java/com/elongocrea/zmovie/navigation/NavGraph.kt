package com.elongocrea.zmovie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elongocrea.zmovie.ui.screen.auth.LoginScreen
import com.elongocrea.zmovie.ui.screen.home.HomeScreen
import com.elongocrea.zmovie.ui.screen.home.SearchScreen
import com.elongocrea.zmovie.ui.screen.movie.MovieListScreen
import com.elongocrea.zmovie.ui.screen.profile.ProfileScreen
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = "home",
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        val disposables = CompositeDisposable()

        composable("login") {
            LoginScreen(navController = navController)
        }

        composable("movies") {
            MovieListScreen(navController = navController, disposables = disposables)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController, disposables = disposables)
        }
        composable(Screen.Search.route) { SearchScreen() }
        composable(Screen.Profile.route) { ProfileScreen() }
//        composable("movie_detail/{movie}") { backStackEntry ->
//            val movieJson = backStackEntry.arguments?.getString("movie")
//            val movie = Gson().fromJson(movieJson, Movie::class.java)
//            MovieDetailScreen(movie = movie)
//        }
    }

}