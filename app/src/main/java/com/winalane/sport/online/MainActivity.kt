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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.winalane.sport.online.data.Sport
import com.winalane.sport.online.ui.common.SharedViewModel
import com.winalane.sport.online.ui.features.acheivements.AchievmentsScreen
import com.winalane.sport.online.ui.features.add_workout.AddWorkOutScreen
import com.winalane.sport.online.ui.features.progress.ProgressScreen
import com.winalane.sport.online.ui.theme.WNLNSportOnlineTheme
import com.winalane.sport.online.ui.features.workout.WorkOutScreen
import com.winalane.sport.online.ui.features.workout.WorkoutViewModel
import kotlinx.coroutines.delay


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


                    NavHost(navController, startDestination = ROUTES.SplashScreen.value) {
                        composable(ROUTES.SplashScreen.value) {
                            SplashScreen(modifier = Modifier) {
                                navController.navigate(ROUTES.MainScreen.value)
                            }
                        }
                        composable(ROUTES.MainScreen.value) {
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
        delay(3000L)
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
            ROUTES.WorkOutScreen.value,
            resourceId = R.string.workout,
            (R.drawable.muscle_up)
        )

    object Achievments : BottomNavigationScreens(
        ROUTES.AcheievementsScreen.value,
        resourceId = R.string.achievements,
        (R.drawable.achievment_icon)
    )

    object Progress : BottomNavigationScreens(
        ROUTES.ProgressScreen.value,
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
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
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
        val workoutViewModel = WorkoutViewModel()
        val sharedViewModel = SharedViewModel<Sport>()

        composable(BottomNavigationScreens.WorkOut.route) {
            WorkOutScreen(modifier = Modifier, onNavigateToAddWorkOut = {
                navController.navigate(ROUTES.AddWorkoutScreen.value)
            }, workoutViewModel,sharedViewModel)
        }
        composable(ROUTES.AddWorkoutScreen.value) {
            AddWorkOutScreen(modifier = Modifier, onNavigateBack = {
                navController.popBackStack()
            },sharedViewModel)
        }
        composable(BottomNavigationScreens.Achievments.route) {
            AchievmentsScreen(modifier = Modifier)
        }
        composable(BottomNavigationScreens.Progress.route) {
            ProgressScreen(modifier = Modifier)
        }
    }
}

enum class ROUTES(var value: String) {
    AddWorkoutScreen("AddWorkoutScreen"),
    SplashScreen("SplashScreen"),
    MainScreen("MainScreen"),
    WorkOutScreen("WorkOutScreen"),
    AcheievementsScreen("AcheivementsScreen"),
    ProgressScreen("ProgressScreen")


}





