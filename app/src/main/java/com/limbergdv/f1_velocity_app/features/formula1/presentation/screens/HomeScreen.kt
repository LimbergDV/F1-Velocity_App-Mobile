package com.limbergdv.f1_velocity_app.features.formula1.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.limbergdv.f1_velocity_app.features.formula1.presentation.components.BottomNavigationBar
import com.limbergdv.f1_velocity_app.features.formula1.presentation.components.HomeContent
import com.limbergdv.f1_velocity_app.features.formula1.presentation.components.NavigationItem
import com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onNavigateToDrivers: () -> Unit = {},
    onNavigateToTeams: () -> Unit = {},
    onNavigateToCircuits: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                selectedItem = NavigationItem.HOME,
                onItemSelected = { item ->
                    when (item) {
                        NavigationItem.HOME -> {
                            // Ya estamos en home, no hacer nada
                        }
                        NavigationItem.DRIVERS -> onNavigateToDrivers()
                        NavigationItem.TEAMS -> onNavigateToTeams()
                        NavigationItem.CIRCUITS -> onNavigateToCircuits()
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HomeContent()
        }
    }
}