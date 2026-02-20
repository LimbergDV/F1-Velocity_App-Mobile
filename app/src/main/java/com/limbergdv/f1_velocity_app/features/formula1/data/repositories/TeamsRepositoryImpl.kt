package com.limbergdv.f1_velocity_app.features.formula1.data.repositories

import com.limbergdv.f1_velocity_app.core.network.OpenF1Api
import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.local.TeamLogos
import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.model.DriverDto
import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Team
import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.TeamsRepository
import javax.inject.Inject

class TeamsRepositoryImpl @Inject constructor(
    private val api: OpenF1Api
) : TeamsRepository {

    override suspend fun getTeams(): List<Team> {
        val response = api.getDrivers()
        val driversList: List<DriverDto> = response.body() ?: emptyList()

        val seenTeams = mutableSetOf<String>()
        val uniqueTeams = mutableListOf<Team>()

        for (i in driversList.indices) {
            val driver: DriverDto = driversList[i]
            val teamName = driver.teamName ?: continue

            if (seenTeams.add(teamName)) {
                uniqueTeams.add(
                    Team(
                        teamName = teamName,
                        teamColour = driver.teamColour ?: "000000",
                        logoUrl = TeamLogos.getLogoUrl(teamName)
                    )
                )
            }
        }

        return uniqueTeams
    }
}