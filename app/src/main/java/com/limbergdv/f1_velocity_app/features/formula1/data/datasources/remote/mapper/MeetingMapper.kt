package com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.mapper

import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.model.MeetingDto
import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Circuit

fun MeetingDto.toDomain(): Circuit {
    return Circuit(
        meetingKey = this.meetingKey,
        meetingName = this.meetingName,
        location = this.location,
        countryName = this.countryName,
        circuitShortName = this.circuitShortName,
        circuitImage = this.circuitImage ?: "",
        countryFlag = this.countryFlag ?: ""
    )
}