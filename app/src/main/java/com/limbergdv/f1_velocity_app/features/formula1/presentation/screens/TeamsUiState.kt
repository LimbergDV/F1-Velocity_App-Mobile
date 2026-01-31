package com.limbergdv.f1_velocity_app.features.formula1.presentation.screens

import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Team

data class TeamsUiState(
    val isLoading: Boolean = false,
    val teams: List<Team> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false
)