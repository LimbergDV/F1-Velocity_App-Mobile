package com.limbergdv.f1_velocity_app.features.formula1.data.repositories

import com.limbergdv.f1_velocity_app.core.network.OpenF1Api
import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.mapper.toDomain
import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.model.DriverDto
import com.limbergdv.f1_velocity_app.features.formula1.domain.entities.Driver
import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.DriversRepository

class DriversRepositoryImpl(
    private val api: OpenF1Api
) : DriversRepository {

    override suspend fun getDrivers(): List<Driver> {
        val response = api.getDrivers()
        val driversList: List<DriverDto> = response.body() ?: emptyList()

        // Filtrar pilotos únicos y tomar solo 20
        val seenNumbers = mutableSetOf<Int>()
        val uniqueDrivers = mutableListOf<Driver>()

        for (i in driversList.indices) {
            val driverDto: DriverDto = driversList[i]
            if (seenNumbers.add(driverDto.driverNumber) && uniqueDrivers.size < 20) {
                uniqueDrivers.add(driverDto.toDomain())
            }
        }

        return uniqueDrivers
    }
}