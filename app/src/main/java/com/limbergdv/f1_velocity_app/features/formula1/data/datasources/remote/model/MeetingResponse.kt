package com.limbergdv.f1_velocity_app.features.formula1.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

data class MeetingDto(
    @SerializedName("meeting_key")
    val meetingKey: Int,
    @SerializedName("meeting_name")
    val meetingName: String,
    @SerializedName("meeting_official_name")
    val meetingOfficialName: String?,
    @SerializedName("location")
    val location: String,
    @SerializedName("country_key")
    val countryKey: Int?,
    @SerializedName("country_code")
    val countryCode: String?,
    @SerializedName("country_name")
    val countryName: String,
    @SerializedName("country_flag")
    val countryFlag: String?,
    @SerializedName("circuit_key")
    val circuitKey: Int?,
    @SerializedName("circuit_short_name")
    val circuitShortName: String,
    @SerializedName("circuit_type")
    val circuitType: String?,
    @SerializedName("circuit_info_url")
    val circuitInfoUrl: String?,
    @SerializedName("circuit_image")
    val circuitImage: String?,
    @SerializedName("year")
    val year: Int
)




