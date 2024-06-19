package com.elongocrea.zmovie.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elongocrea.zmovie.MyApplication
import com.elongocrea.zmovie.ui.screen.movie.MovieListScreen
import com.elongocrea.zmovie.ui.theme.ZMovieTheme
import com.elongocrea.zmovie.viewmodel.MovieViewModel
import com.elongocrea.zmovie.viewmodel.MovieViewModelFactory
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivity : ComponentActivity() {

    private val disposables = CompositeDisposable()
    private val movieViewModel: MovieViewModel by viewModels {
        MovieViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZMovieTheme {
                MyApp {
                    MovieListScreen(viewModel = movieViewModel, disposables = disposables)
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ZMovieTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ZMovieTheme {
        // Greeting("Android")
    }
}