package com.mashup.alcoholfree.domain.model

data class MeasureResultDomainModel(
    val alcoholCalorie: Int,
    val averageAlcoholContent: Double,
    val drankAt: String,
    val drinkingDuration: String,
    val drinks: List<DrinkDomainModel>,
    val id: String,
    val totalDrinkGlasses: Int,
)
