package com.limbergdv.f1_velocity_app.features.formula1.presentation.screens

import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Driver

data class DriversUiState(
    val isLoading: Boolean = false,
    val drivers: List<Driver> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false
)





