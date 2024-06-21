import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.elongocrea.zmovie.ui.theme.PrimaryColor
import com.elongocrea.zmovie.ui.theme.SecondaryColor

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    data object Home : Screen("home", "Home", Icons.Default.Home)
    data object Search : Screen("search", "Search", Icons.Default.Search)
    data object Profile : Screen("profile", "Profile", Icons.Default.AccountCircle)
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val items = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Profile
    )

//    BottomAppBar(
//        containerColor = PrimaryColor,
//        modifier = Modifier.border(width = 1.dp, color = Color.Red)
//    ) {
//        items.forEach { screen ->
//            IconButton(
//                modifier = Modifier.weight(1f),
//                onClick = { /*TODO*/ }
//            ) {
//                Icon(
//                    contentDescription = screen.title,
//                    imageVector = screen.icon,
//                    modifier = Modifier.size(26.dp)
//                )
//            }
//        }
//    }

    Box(
        modifier = Modifier
            .padding(bottom = 16.dp, start = 8.dp, end = 8.dp, top = 16.dp)
    ) {
        NavigationBar(
            containerColor = Color.Transparent,
            modifier = Modifier
                .align(Alignment.Center)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                        .background(color = PrimaryColor)
                ) {
                    items.forEach { screen ->
                        NavigationBarItem(
                            icon = { Icon(screen.icon, contentDescription = null) },
                            label = { Text(screen.title) },
                            selected = currentRoute == screen.route,
                            colors = NavigationBarItemColors(
                                unselectedIconColor = Color.White,
                                unselectedTextColor = Color.White,
                                selectedTextColor = SecondaryColor,
                                selectedIconColor = PrimaryColor,
                                selectedIndicatorColor = SecondaryColor,
                                disabledTextColor = Color.White,
                                disabledIconColor = Color.White,
                            ),
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
