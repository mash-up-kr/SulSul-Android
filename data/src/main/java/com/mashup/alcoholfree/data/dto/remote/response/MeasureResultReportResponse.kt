package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName

data class MeasureResultReportResponse(
    @SerializedName("alcoholCalorie")
    val alcoholCalorie: Int,
    @SerializedName("averageAlcoholContent")
    val averageAlcoholContent: Double,
    @SerializedName("drankAt")
    val drankAt: String,
    @SerializedName("drinkingDuration")
    val drinkingDuration: String,
    @SerializedName("drinks")
    val drinks: List<DrinkResponse>,
    @SerializedName("id")
    val id: String,
    @SerializedName("totalDrinkGlasses")
    val totalDrinkGlasses: Int,
)
