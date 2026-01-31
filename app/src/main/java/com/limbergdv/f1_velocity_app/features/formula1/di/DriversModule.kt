package com.limbergdv.f1_velocity_app.features.formula1.di

import com.limbergdv.f1_velocity_app.core.di.AppContainer
import com.limbergdv.f1_velocity_app.features.formula1.domain.usecases.GetDriversUseCase
import com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels.DriversViewModelFactory

class DriversModule(
    private val appContainer: AppContainer
) {

    private fun provideGetDriversUseCase(): GetDriversUseCase {
        return GetDriversUseCase(appContainer.driversRepository)
    }

    fun provideDriversViewModelFactory(): DriversViewModelFactory {
        return DriversViewModelFactory(
            getDriversUseCase = provideGetDriversUseCase()
        )
    }
}