package com.limbergdv.f1_velocity_app.features.formula1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.limbergdv.f1_velocity_app.core.di.AppContainer
import com.limbergdv.f1_velocity_app.features.formula1.di.CircuitsModule
import com.limbergdv.f1_velocity_app.features.formula1.di.DriversModule
import com.limbergdv.f1_velocity_app.features.formula1.di.TeamsModule
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
fun F1Navigation(appContainer: AppContainer) {
    val navController = rememberNavController()
    val driversModule = DriversModule(appContainer)
    val circuitsModule = CircuitsModule(appContainer)
    val teamsModule = TeamsModule(appContainer)

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToDrivers = {
                    navController.navigate(Screen.Drivers.route)
                },
                onNavigateToTeams = {
                    navController.navigate(Screen.Teams.route)
                },
                onNavigateToCircuits = {
                    navController.navigate(Screen.Circuits.route)
                }
            )
        }

        composable(Screen.Drivers.route) {
            DriversScreen(
                factory = driversModule.provideDriversViewModelFactory(),
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route)
                },
                onNavigateToTeams = {
                    navController.navigate(Screen.Teams.route)
                },
                onNavigateToCircuits = {
                    navController.navigate(Screen.Circuits.route)
                }
            )
        }


        composable(Screen.Teams.route) {

            TeamsScreen(
                factory = teamsModule.provideTeamsViewModelFactory(),
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route)
                },
                onNavigateToDrivers = {
                    navController.navigate(Screen.Drivers.route)
                },
                onNavigateToCircuits = {
                    navController.navigate(Screen.Circuits.route)
                }
            )
        }
        composable(Screen.Circuits.route) {
            CircuitsScreen(
                factory = circuitsModule.provideCircuitsViewModelFactory(),
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route)
                },
                onNavigateToDrivers = {
                    navController.navigate(Screen.Drivers.route)
                },
                onNavigateToTeams = {
                    navController.navigate(Screen.Teams.route)
                }
            )
        }

    }
}