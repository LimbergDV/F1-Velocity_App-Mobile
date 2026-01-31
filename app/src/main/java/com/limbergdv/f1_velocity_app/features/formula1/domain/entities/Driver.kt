package com.limbergdv.f1_velocity_app.features.formula1.domain.entities

data class Driver(
    val driverNumber: Int,
    val firstName: String,
    val lastName: String,
    val teamName: String,
    val headshotUrl: String,
    val teamColour: String
)
