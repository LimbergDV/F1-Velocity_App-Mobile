package com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.limbergdv.f1_velocity_app.features.formula1.domain.usecases.GetCircuitsUseCase
import com.limbergdv.f1_velocity_app.features.formula1.presentation.screens.CircuitsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CircuitsViewModel @Inject constructor(
    private val getCircuitsUseCase: GetCircuitsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CircuitsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadCircuits()
    }

    private fun loadCircuits() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getCircuitsUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { list ->
                        currentState.copy(isLoading = false, circuits = list)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }
}