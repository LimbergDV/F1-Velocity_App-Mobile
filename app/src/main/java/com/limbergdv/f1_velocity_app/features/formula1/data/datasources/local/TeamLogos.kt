package com.limbergdv.f1_velocity_app.features.formula1.data.datasources.local

object TeamLogos {
    private val logos = mapOf(
        "Red Bull Racing" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/Red_Bull_Racing_logo.png",
        "Ferrari" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/ferlogo.png",
        "Mercedes" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/Mercedes_logo.png",
        "McLaren" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/Mclaren_logo.png",
        "Aston Martin" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/LOGO_ASTON_MARTIN.webp",
        "Alpine" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/Alpine_F1_Team_Logo.png",
        "Williams" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/Williams_racing_logo.webp",
        "AlphaTauri" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/Alpha-logo.png",
        "Kick Sauber" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/sauberf1_logo.png",
        "Haas F1 Team" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/Haas_F1_Team_Logo.png",
        "Racing Bulls" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/racingbulls_logo.png",
        "Alfa Romeo" to "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/Logo_Alfa_Romeo_Racing.png",
    )

    fun getLogoUrl(teamName: String): String {
        return logos[teamName] ?: "https://container-images-limbi.s3.us-east-1.amazonaws.com/teams/f1.png"
    }
}