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
    companion object {
        fun toDomainModel(response: MeasureResultResponse): MeasureResult {
            return MeasureResult(
                alcoholCalorie = response.alcoholCalorie,
                averageAlcoholContent = response.averageAlcoholContent,
                drankAt = response.drankAt,
                drinkingDuration = response.drinkingDuration,
                drinks = response.drinks.map { DrinkResponse.toDomainModel(it) },
                id = response.id,
                totalDrinkGlasses = response.totalDrinkGlasses,
            )
        }
    }
}
