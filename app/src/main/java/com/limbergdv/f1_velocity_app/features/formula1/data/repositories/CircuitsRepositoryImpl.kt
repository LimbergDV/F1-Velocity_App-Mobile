package com.limbergdv.f1_velocity_app.features.formula1.data.repositories

import com.limbergdv.f1_velocity_app.core.network.OpenF1Api
import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.mapper.toDomain
import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.model.MeetingDto
import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Circuit
import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.CircuitsRepository

class CircuitsRepositoryImpl(
    private val api: OpenF1Api
) : CircuitsRepository {

    override suspend fun getCircuits(): List<Circuit> {
        // Obtener meetings del año 2025 (año actual de F1)
        val response = api.getMeetings(year = 2025)
        val meetingsList: List<MeetingDto> = response.body() ?: emptyList()

        // Filtrar solo los Grand Prix (excluir Pre-Season Testing)
        // y obtener circuitos únicos
        val seenCircuits = mutableSetOf<String>()
        val uniqueCircuits = mutableListOf<Circuit>()

        for (i in meetingsList.indices) {
            val meeting: MeetingDto = meetingsList[i]
            // Filtrar solo Grand Prix y evitar duplicados por circuitShortName
            if (meeting.meetingName.contains("Grand Prix") &&
                seenCircuits.add(meeting.circuitShortName)) {
                uniqueCircuits.add(meeting.toDomain())
            }
        }

        return uniqueCircuits
    }
}




