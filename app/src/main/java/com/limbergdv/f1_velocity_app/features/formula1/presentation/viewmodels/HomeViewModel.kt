package com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.limbergdv.f1_velocity_app.features.formula1.presentation.screens.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun onNavigationItemSelected(index: Int) {
        _uiState.update { it.copy(selectedNavigationItem = index) }
    }
}