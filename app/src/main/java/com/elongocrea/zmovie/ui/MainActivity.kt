package com.elongocrea.zmovie.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elongocrea.zmovie.MyApplication
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ZMovieTheme {
        Greeting("Android")
    }
}