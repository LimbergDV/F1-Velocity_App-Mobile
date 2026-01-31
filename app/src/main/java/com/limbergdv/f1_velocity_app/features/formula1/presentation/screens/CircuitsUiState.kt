package com.limbergdv.f1_velocity_app.features.formula1.presentation.screens

import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Circuit

data class CircuitsUiState(
    val isLoading: Boolean = false,
    val circuits: List<Circuit> = emptyList(),
    val error: String? = null
)
