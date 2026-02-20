package com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.limbergdv.f1_velocity_app.features.formula1.domain.usecases.GetDriversUseCase
import com.limbergdv.f1_velocity_app.features.formula1.presentation.screens.DriversUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriversViewModel @Inject constructor(
    private val getDriversUseCase: GetDriversUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DriversUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadDrivers()
    }

    private fun loadDrivers() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getDriversUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { list ->
                        currentState.copy(isLoading = false, drivers = list)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }
}