package com.limbergdv.f1_velocity_app.features.formula1.domain.usecases

import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Team
import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.TeamsRepository
import javax.inject.Inject

class GetTeamsUseCase @Inject constructor(
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