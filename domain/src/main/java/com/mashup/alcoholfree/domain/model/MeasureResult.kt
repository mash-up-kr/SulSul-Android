package com.mashup.alcoholfree.domain.model

data class MeasureResult(
    val alcoholCalorie: Int,
    val averageAlcoholPercent: Double,
    val drankAt: String,
    val drinkingDuration: String,
    val drinks: List<Drink>,
    val id: String,
    val totalDrinkGlasses: Int,
    val tier: String,
    val extraGlasses: Int,
)
