package com.limbergdv.f1_velocity_app.features.formula1.data.repositories

import com.limbergdv.f1_velocity_app.core.network.OpenF1Api
import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.mapper.toDomain
import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.model.MeetingDto
import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Circuit
import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.CircuitsRepository
import javax.inject.Inject

class CircuitsRepositoryImpl @Inject constructor(
    private val api: OpenF1Api
) : CircuitsRepository {

    override suspend fun getCircuits(): List<Circuit> {
        val response = api.getMeetings(year = 2025)
        val meetingsList: List<MeetingDto> = response.body() ?: emptyList()

        val seenCircuits = mutableSetOf<String>()
        val uniqueCircuits = mutableListOf<Circuit>()

        for (i in meetingsList.indices) {
            val meeting: MeetingDto = meetingsList[i]
            if (meeting.meetingName.contains("Grand Prix") &&
                seenCircuits.add(meeting.circuitShortName)) {
                uniqueCircuits.add(meeting.toDomain())
            }
        }

        return uniqueCircuits
    }
}