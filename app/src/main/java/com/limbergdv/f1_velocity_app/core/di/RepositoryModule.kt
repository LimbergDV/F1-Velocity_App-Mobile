package com.limbergdv.f1_velocity_app.core.di

import com.limbergdv.f1_velocity_app.features.formula1.data.repositories.CircuitsRepositoryImpl
import com.limbergdv.f1_velocity_app.features.formula1.data.repositories.DriversRepositoryImpl
import com.limbergdv.f1_velocity_app.features.formula1.data.repositories.TeamsRepositoryImpl
import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.CircuitsRepository
import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.DriversRepository
import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.TeamsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDriversRepository(
        impl: DriversRepositoryImpl
    ): DriversRepository

    @Binds
    abstract fun bindCircuitsRepository(
        impl: CircuitsRepositoryImpl
    ): CircuitsRepository

    @Binds
    abstract fun bindTeamsRepository(
        impl: TeamsRepositoryImpl
    ): TeamsRepository
}