package com.limbergdv.f1_velocity_app.features.formula1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.limbergdv.f1_velocity_app.features.formula1.presentation.screens.CircuitsScreen
import com.limbergdv.f1_velocity_app.features.formula1.presentation.screens.DriversScreen
import com.limbergdv.f1_velocity_app.features.formula1.presentation.screens.HomeScreen
import com.limbergdv.f1_velocity_app.features.formula1.presentation.screens.TeamsScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Drivers : Screen("drivers")
    object Circuits : Screen("circuits")
    object Teams : Screen("teams")
}

@Composable
fun F1Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToDrivers = { navController.navigate(Screen.Drivers.route) },
                onNavigateToTeams = { navController.navigate(Screen.Teams.route) },
                onNavigateToCircuits = { navController.navigate(Screen.Circuits.route) }
            )
        }

        composable(Screen.Drivers.route) {
            DriversScreen(
                onNavigateToHome = { navController.navigate(Screen.Home.route) },
                onNavigateToTeams = { navController.navigate(Screen.Teams.route) },
                onNavigateToCircuits = { navController.navigate(Screen.Circuits.route) }
            )
        }

        composable(Screen.Teams.route) {
            TeamsScreen(
                onNavigateToHome = { navController.navigate(Screen.Home.route) },
                onNavigateToDrivers = { navController.navigate(Screen.Drivers.route) },
                onNavigateToCircuits = { navController.navigate(Screen.Circuits.route) }
            )
        }

        composable(Screen.Circuits.route) {
            CircuitsScreen(
                onNavigateToHome = { navController.navigate(Screen.Home.route) },
                onNavigateToDrivers = { navController.navigate(Screen.Drivers.route) },
                onNavigateToTeams = { navController.navigate(Screen.Teams.route) }
            )
        }
    }
}