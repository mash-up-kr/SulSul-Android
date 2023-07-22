package com.mashup.alcoholfree.data.model.measure

import com.mashup.alcoholfree.data.dto.remote.response.MeasureResultResponse
import com.mashup.alcoholfree.domain.model.MeasureResult

data class MeasureResultDataModel(
    val alcoholCalorie: Int,
    val averageAlcoholContent: Double,
    val drankAt: String,
    val drinkingDuration: String,
    val drinks: List<DrinkDataModel>,
    val id: String,
    val totalDrinkGlasses: Int,
) {
    companion object {
        fun toDataModel(response: MeasureResultResponse): MeasureResultDataModel {
            return MeasureResultDataModel(
                alcoholCalorie = response.alcoholCalorie,
                averageAlcoholContent = response.averageAlcoholContent,
                drankAt = response.drankAt,
                drinkingDuration = response.drinkingDuration,
                drinks = response.drinks.map { DrinkDataModel.toDataModel(it) },
                id = response.id,
                totalDrinkGlasses = response.totalDrinkGlasses,
            )
        }

        fun toDomainModel(data: MeasureResultDataModel): MeasureResult {
            return MeasureResult(
                alcoholCalorie = data.alcoholCalorie,
                averageAlcoholContent = data.averageAlcoholContent,
                drankAt = data.drankAt,
                drinkingDuration = data.drinkingDuration,
                drinks = data.drinks.map { DrinkDataModel.toDomainModel(it) },
                id = data.id,
                totalDrinkGlasses = data.totalDrinkGlasses,
            )
        }
    }
}
