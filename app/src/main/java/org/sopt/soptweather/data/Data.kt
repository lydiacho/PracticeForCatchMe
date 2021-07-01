package org.sopt.soptweather.data

import com.google.gson.annotations.SerializedName

data class Data(
        @SerializedName("name")
        val city:String,
        val country:String
)