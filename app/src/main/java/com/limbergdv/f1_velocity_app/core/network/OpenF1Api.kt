package com.limbergdv.f1_velocity_app.core.network

import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.model.DriverDto
import retrofit2.Response

import retrofit2.http.GET

interface OpenF1Api {
    @GET("v1/drivers")
    suspend fun getDrivers(): Response<List<DriverDto>>
}