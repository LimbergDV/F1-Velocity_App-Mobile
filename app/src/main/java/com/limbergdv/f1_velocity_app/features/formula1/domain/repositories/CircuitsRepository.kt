package com.limbergdv.f1_velocity_app.features.formula1.domain.repositories

import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Circuit

interface CircuitsRepository {
    suspend fun getCircuits(): List<Circuit>
}