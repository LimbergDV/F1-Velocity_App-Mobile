package com.limbergdv.f1_velocity_app.core.network

import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.model.DriverDto
import com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.model.MeetingDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenF1Api {
    @GET("v1/drivers")
    suspend fun getDrivers(): Response<List<DriverDto>>

    @GET("v1/meetings")
    suspend fun getMeetings(
        @Query("year") year: Int
    ): Response<List<MeetingDto>>
}