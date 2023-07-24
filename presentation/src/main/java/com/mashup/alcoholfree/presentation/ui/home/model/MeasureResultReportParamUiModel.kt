package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.domain.model.MeasureResultReportParam

data class MeasureResultReportParamUiModel(
    val drinkingEndTime: String,
    val drinkingStartTime: String,
    val drinks: List<DrinkUiModel>,
    val totalDrinkGlasses: Int,
)

fun MeasureResultReportParamUiModel.toDomainModel() =
    MeasureResultReportParam(
        drinkingEndTime = drinkingEndTime,
        drinkingStartTime = drinkingStartTime,
        drinks = drinks.map { it.toDomainModel() },
        totalDrinkGlasses = totalDrinkGlasses,
    )
