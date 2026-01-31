package com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.mapper

import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.model.DriverDto
import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Driver

fun DriverDto.toDomain(): Driver {
    return Driver(
        driverNumber = this.driverNumber,
        firstName = this.firstName,
        lastName = this.lastName,
        teamName = this.teamName ?: "Unknown Team",
        headshotUrl = this.headshotUrl ?: "",
        teamColour = this.teamColour ?: "000000"
    )
}