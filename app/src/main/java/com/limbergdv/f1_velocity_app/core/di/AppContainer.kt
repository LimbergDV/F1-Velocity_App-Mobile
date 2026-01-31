package com.limbergdv.f1_velocity_app.core.di

import android.content.Context
import com.limbergdv.f1_velocity_app.core.network.OpenF1Api
import com.limbergdv.f1_velocity_app.features.formula1.data.repositories.DriversRepositoryImpl
import com.limbergdv.f1_velocity_app.features.formula1.domain.repositories.DriversRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {

    private val openF1Retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openf1.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val openF1Api: OpenF1Api by lazy {
        openF1Retrofit.create(OpenF1Api::class.java)
    }

    val driversRepository: DriversRepository by lazy {
        DriversRepositoryImpl(openF1Api)
    }
}