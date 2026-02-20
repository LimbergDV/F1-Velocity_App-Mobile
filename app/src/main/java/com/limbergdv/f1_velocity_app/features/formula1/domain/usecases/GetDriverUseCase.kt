package com.limbergdv.f1_velocity_app.features.formula1.domain.usecases

import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Driver
import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.DriversRepository
import javax.inject.Inject

class GetDriversUseCase @Inject constructor(
    private val repository: DriversRepository
) {
    suspend operator fun invoke(): Result<List<Driver>> {
        return try {
            val drivers = repository.getDrivers()
            if (drivers.isEmpty()) {
                Result.failure(Exception("No se encontraron pilotos"))
            } else {
                Result.success(drivers)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}