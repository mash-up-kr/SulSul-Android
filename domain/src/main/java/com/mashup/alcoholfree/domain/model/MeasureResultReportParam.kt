package com.mashup.alcoholfree.domain.model

data class MeasureResultReportParam(
    val drinkingEndTime: String,
    val drinkingStartTime: String,
    val drinks: List<Drink>,
    val totalDrinkGlasses: Int,
)
