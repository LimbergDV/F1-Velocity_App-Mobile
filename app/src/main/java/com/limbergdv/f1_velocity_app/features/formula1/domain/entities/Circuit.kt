package com.limbergdv.f1_velocity_app.features.formula1.domain.entities

data class Circuit(
    val meetingKey: Int,
    val meetingName: String,
    val location: String,
    val countryName: String,
    val circuitShortName: String,
    val circuitImage: String,
    val countryFlag: String
)