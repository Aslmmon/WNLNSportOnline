package com.winalane.sport.online

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.winalane.sport.online.ui.acheivements.AchievmentsScreen
import com.winalane.sport.online.ui.progress.ProgressScreen
import com.winalane.sport.online.ui.theme.WNLNSportOnlineTheme
import com.winalane.sport.online.ui.workout.WorkOutScreen
import kotlinx.coroutines.delay

val KEY_ROUTE: String? = "route"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WNLNSportOnlineTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()


                    NavHost(navController, startDestination = "splash") {
                        composable("splash") {
                            SplashScreen(modifier = Modifier) {
                                navController.navigate("MainScreen")
                            }
                        }
                        composable("MainScreen") {
                            MainScreen()
                        }

                    }
                }
            }
        }
    }
}


@Composable
fun MainScreen() {

    val navController = rememberNavController()

    val bottomNavigationItems = listOf(
        BottomNavigationScreens.WorkOut,
        BottomNavigationScreens.Achievments,
        BottomNavigationScreens.Progress,

        )
    Scaffold(
        bottomBar = {
            SpookyAppBottomNavigation(navController, bottomNavigationItems)
        }
    ) {
        MainScreenNavigationConfigurations(navController, it)
    }
}

@Composable
fun SplashScreen(modifier: Modifier = Modifier, onNavigateToHOme: () -> Unit) {

    LaunchedEffect(Unit) {
        delay(5000L)
        onNavigateToHOme.invoke()
    }

    Image(
        modifier = modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.loading),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,

        )

}

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val icon: Int
) {
    object WorkOut :
        BottomNavigationScreens(
            "WorkOut",
            resourceId = R.string.workout,
            (R.drawable.muscle_up)
        )

    object Achievments : BottomNavigationScreens(
        "Achievments",
        resourceId = R.string.achievements,
        (R.drawable.achievment_icon)
    )

    object Progress : BottomNavigationScreens(
        "Progress",
        resourceId = R.string.progress,
        (R.drawable.progress_icon)
    )
}

@Composable
private fun SpookyAppBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation(backgroundColor = MaterialTheme.colorScheme.tertiary) {
        val backStackEntry = navController.currentBackStackEntryAsState()

        items.forEach { screen ->
            val currentRoute = backStackEntry.value?.destination?.route
            val selected = currentRoute == screen.route

            BottomNavigationItem(
                label = {
                    Text(
                        stringResource(id = screen.resourceId),
                        style = MaterialTheme.typography.labelMedium,
                        color = if (selected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.surfaceContainer
                    )
                },
                selectedContentColor = MaterialTheme.colorScheme.secondary,
                unselectedContentColor = MaterialTheme.colorScheme.tertiary,
                selected = selected,
                icon = {
                    Icon(
                        painterResource(id = screen.icon),
                        contentDescription = null,
                        tint = if (selected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.surfaceContainer
                    )
                },
                onClick = {
                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {

    NavHost(
        navController,
        startDestination = BottomNavigationScreens.WorkOut.route,
        Modifier.padding(paddingValues)
    ) {
        composable(BottomNavigationScreens.WorkOut.route) {
            WorkOutScreen(modifier = Modifier)
        }
        composable(BottomNavigationScreens.Achievments.route) {
            AchievmentsScreen(modifier = Modifier)
        }
        composable(BottomNavigationScreens.Progress.route) {
            ProgressScreen(modifier = Modifier)
        }
    }
}





