package com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.limbergdv.f1_velocity_app.features.formula1.domain.usecases.GetTeamsUseCase

class TeamsViewModelFactory(
    private val getTeamsUseCase: GetTeamsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeamsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TeamsViewModel(getTeamsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}