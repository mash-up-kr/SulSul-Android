package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.MeasureResult

data class MeasureResultResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("totalDrinkGlasses")
    val totalDrinkGlasses: Int,
    @SerializedName("title")
    val tier: String,
    @SerializedName("averageAlcoholPercent")
    val averageAlcoholPercent: Double,
    @SerializedName("extraGlasses")
    val extraGlasses: Int,
    @SerializedName("drinkingDuration")
    val drinkingDuration: String,
    @SerializedName("alcoholCalorie")
    val alcoholCalorie: Int,
    @SerializedName("drankAt")
    val drankAt: String,
    @SerializedName("drinks")
    val drinks: List<DrinkResponse>,
) {
    fun toDomainModel(): MeasureResult {
        return MeasureResult(
            id = id,
            totalDrinkGlasses = totalDrinkGlasses,
            tier = tier,
            alcoholCalorie = alcoholCalorie,
            averageAlcoholPercent = averageAlcoholPercent,
            extraGlasses = extraGlasses,
            drankAt = drankAt,
            drinkingDuration = drinkingDuration,
            drinks = drinks.map { it.toDomainModel() },
        )
    }
}
