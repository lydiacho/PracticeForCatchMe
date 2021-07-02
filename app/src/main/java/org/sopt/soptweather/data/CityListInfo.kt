package org.sopt.soptweather.data

import com.google.gson.annotations.SerializedName

data class CityListInfo(
        val id: Int,
        @SerializedName("name")
        val city: String,
        val country: String,
        val coord: Coord
)
data class Coord(
        val lat: Double,
        val lon: Double
)