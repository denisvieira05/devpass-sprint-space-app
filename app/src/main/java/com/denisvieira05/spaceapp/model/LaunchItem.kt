package com.denisvieira05.spaceapp.model

import com.google.gson.annotations.SerializedName

data class LaunchItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("details")
    val details: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("date_utc")
    val date: String,
    @SerializedName("flight_number")
    val flightNumber: String
)