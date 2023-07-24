package com.mashup.alcoholfree.data.dto.remote.request

import com.mashup.alcoholfree.domain.model.MeasureResultReportParam

data class MeasureResultReportRequest(
    val drinkingEndTime: String,
    val drinkingStartTime: String,
    val drinks: List<DrinkRequest>,
    val totalDrinkGlasses: Int,
)

fun MeasureResultReportParam.toRequestModel(): MeasureResultReportRequest {
    return MeasureResultReportRequest(
        drinkingEndTime = drinkingEndTime,
        drinkingStartTime = drinkingStartTime,
        drinks = drinks.map { it.toRequestModel() },
        totalDrinkGlasses = totalDrinkGlasses,
    )
}
