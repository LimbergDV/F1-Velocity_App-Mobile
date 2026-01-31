package com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.limbergdv.f1_velocity_app.features.formula1.domain.usecases.GetCircuitsUseCase

class CircuitsViewModelFactory(
    private val getCircuitsUseCase: GetCircuitsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CircuitsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CircuitsViewModel(getCircuitsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}