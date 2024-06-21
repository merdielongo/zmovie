package com.elongocrea.zmovie.ui

import BottomNavigationBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
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
                val navController = rememberNavController()

                val currentRoute = navController.currentDestination?.route
                when (currentRoute) {
                    "login" -> AuthLayout {
                        NavGraph(navController = navController)
                    }
                    else -> MainLayout(navController = navController) {
                        NavGraph(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun MainLayout(navController: NavHostController, content: @Composable () -> Unit) {

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = if (!isSystemInDarkTheme()) BgGray100 else MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun AuthLayout(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BgGray100
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ZMovieTheme {
        // Greeting("Android")
    }
}
