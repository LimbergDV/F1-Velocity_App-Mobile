package com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.limbergdv.f1_velocity_app.features.formula1.domain.usecases.GetDriversUseCase

class DriversViewModelFactory (
    private val getDriversUseCase: GetDriversUseCase
) : ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DriversViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return DriversViewModel(getDriversUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class ${modelClass.name}$")
    }
}