package com.limbergdv.f1_velocity_app.features.formula1.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.limbergdv.f1_velocity_app.features.formula1.presentation.components.BottomNavigationBar
import com.limbergdv.f1_velocity_app.features.formula1.presentation.components.NavigationItem
import com.limbergdv.f1_velocity_app.features.formula1.presentation.components.TeamCard
import com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels.TeamsViewModel
import com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels.TeamsViewModelFactory

@Composable
fun TeamsScreen(
    factory: TeamsViewModelFactory,
    onNavigateToHome: () -> Unit = {},
    onNavigateToDrivers: () -> Unit = {},
    onNavigateToCircuits: () -> Unit = {}
) {
    val viewModel: TeamsViewModel = viewModel(factory = factory)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                selectedItem = NavigationItem.TEAMS,
                onItemSelected = { item ->
                    when (item) {
                        NavigationItem.HOME -> onNavigateToHome()
                        NavigationItem.DRIVERS -> onNavigateToDrivers()
                        NavigationItem.TEAMS -> {
                        }
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
                .background(Color.White)
        ) {
            when {
                uiState.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = Color(0xFFDC0000)
                    )
                }
                uiState.error != null -> {
                    Text(
                        text = uiState.error ?: "Error",
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.Red,
                        fontSize = 16.sp
                    )
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 16.dp)
                    ) {
                        item {
                            Text(
                                text = "Teams",
                                fontSize = 48.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                        }

                        items(uiState.teams) { team ->
                            TeamCard(
                                teamName = team.teamName,
                                teamColour = team.teamColour,
                                logoUrl = team.logoUrl
                            )
                        }
                    }
                }
            }
        }
    }
}