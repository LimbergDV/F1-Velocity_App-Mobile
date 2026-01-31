package com.limbergdv.f1_velocity_app.features.formula1.di

import com.limbergdv.f1_velocity_app.core.di.AppContainer
import com.limbergdv.f1_velocity_app.features.formula1.domain.usecases.GetTeamsUseCase
import com.limbergdv.f1_velocity_app.features.formula1.presentation.viewmodels.TeamsViewModelFactory

class TeamsModule(
    private val appContainer: AppContainer
) {

    private fun provideGetTeamsUseCase(): GetTeamsUseCase {
        return GetTeamsUseCase(appContainer.teamsRepository)
    }

    fun provideTeamsViewModelFactory(): TeamsViewModelFactory {
        return TeamsViewModelFactory(
            getTeamsUseCase = provideGetTeamsUseCase()
        )
    }
}