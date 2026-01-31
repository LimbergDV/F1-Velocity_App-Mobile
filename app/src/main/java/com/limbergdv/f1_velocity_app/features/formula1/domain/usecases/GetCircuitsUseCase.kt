package com.limbergdv.f1_velocity_app.features.formula1.domain.usecases

import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.CircuitsRepository
import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Circuit

class GetCircuitsUseCase(
    private val repository: CircuitsRepository
) {

    suspend operator fun invoke(): Result<List<Circuit>> {
        return try {
            val circuits = repository.getCircuits()

            if (circuits.isEmpty()) {
                Result.failure(Exception("No se encontraron circuitos"))
            } else {
                Result.success(circuits)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}