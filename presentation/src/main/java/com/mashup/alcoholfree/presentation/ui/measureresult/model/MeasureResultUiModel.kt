package com.mashup.alcoholfree.presentation.ui.measureresult.model

import com.mashup.alcoholfree.domain.model.Drink
import com.mashup.alcoholfree.domain.model.MeasureResult

data class MeasureResultUiModel(
    val headerStatus: String,
    val userName: String,
    val totalDrinkCountOfCup: Int,
    val averageAlcoholPercent: Double,
    val totalDrinkKcal: Int,
    val totalDrinkTime: String,
    val drinkCountOfSoju: Int,
    val drinkCountOfBeer: Int,
    val drinkCountOfKaoliangju: Int,
    val drinkCountOfWine: Int,
    val drinkCountOfWhisky: Int,
    val extraGlasses: Int,
)

fun MeasureResult.toUiModel(): MeasureResultUiModel {
    val soju: Drink? = drinks.firstOrNull { it.drinkType == "소주" }
    val beer: Drink? = drinks.firstOrNull { it.drinkType == "맥주" }
    val kaoliangju: Drink? = drinks.firstOrNull { it.drinkType == "고량주" }
    val wine: Drink? = drinks.firstOrNull { it.drinkType == "와인" }
    val whisky: Drink? = drinks.firstOrNull { it.drinkType == "위스키" }

    return MeasureResultUiModel(
        headerStatus = tier,
        userName = "임시",
        totalDrinkCountOfCup = totalDrinkGlasses,
        averageAlcoholPercent = averageAlcoholPercent,
        totalDrinkKcal = alcoholCalorie,
        totalDrinkTime = drinkingDuration,
        drinkCountOfSoju = soju?.glasses ?: 0,
        drinkCountOfBeer = beer?.glasses ?: 0,
        drinkCountOfKaoliangju = kaoliangju?.glasses ?: 0,
        drinkCountOfWine = wine?.glasses ?: 0,
        drinkCountOfWhisky = whisky?.glasses ?: 0,
        extraGlasses = extraGlasses,
    )
}
