package com.limbergdv.f1_velocity_app.features.formula1.di

import com.limbergdv.f1_velocity_app.core.di.AppContainer
import com.limbergdv.f1_velocity_app.features.formula1.domain.usecases.GetCircuitsUseCase
import com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels.CircuitsViewModelFactory

class CircuitsModule(
    private val appContainer: AppContainer
) {

    private fun provideGetCircuitsUseCase(): GetCircuitsUseCase {
        return GetCircuitsUseCase(appContainer.circuitsRepository)
    }

    fun provideCircuitsViewModelFactory(): CircuitsViewModelFactory {
        return CircuitsViewModelFactory(
            getCircuitsUseCase = provideGetCircuitsUseCase()
        )
    }
}