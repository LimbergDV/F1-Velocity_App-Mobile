package com.limbergdv.f1_velocity_app.features.formula1.domain.usecases

import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.TeamsRepository
import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Team

class GetTeamsUseCase(
    private val repository: TeamsRepository
) {

    suspend operator fun invoke(): Result<List<Team>> {
        return try {
            val teams = repository.getTeams()

            if (teams.isEmpty()) {
                Result.failure(Exception("No se encontraron equipos"))
            } else {
                Result.success(teams)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}