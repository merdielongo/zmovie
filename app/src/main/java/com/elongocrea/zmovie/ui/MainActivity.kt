package com.elongocrea.zmovie.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.elongocrea.zmovie.navigation.NavGraph
import com.elongocrea.zmovie.ui.theme.BgGray100
import com.elongocrea.zmovie.ui.theme.ZMovieTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZMovieTheme {
                MyApp {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
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
            color = BgGray100
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