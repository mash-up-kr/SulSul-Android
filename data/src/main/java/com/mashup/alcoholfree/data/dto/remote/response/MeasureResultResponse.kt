package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.MeasureResult

data class MeasureResultResponse(
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
) {
    fun toDomainModel(): MeasureResult {
        return MeasureResult(
            alcoholCalorie = alcoholCalorie,
            averageAlcoholContent = averageAlcoholContent,
            drankAt = drankAt,
            drinkingDuration = drinkingDuration,
            drinks = drinks.map { it.toDomainModel() },
            id = id,
            totalDrinkGlasses = totalDrinkGlasses,
        )
    }
}
