package com.mashup.alcoholfree.domain.model

data class MeasureResult(
    val alcoholCalorie: Int,
    val averageAlcoholContent: Double,
    val drankAt: String,
    val drinkingDuration: String,
    val drinks: List<Drink>,
    val id: String,
    val totalDrinkGlasses: Int,
)
