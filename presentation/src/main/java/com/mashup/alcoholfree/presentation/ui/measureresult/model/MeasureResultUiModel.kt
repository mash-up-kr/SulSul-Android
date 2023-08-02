package com.mashup.alcoholfree.presentation.ui.measureresult.model

import com.mashup.alcoholfree.domain.model.Drink
import com.mashup.alcoholfree.domain.model.MeasureResult
import com.mashup.alcoholfree.presentation.ui.home.model.DrinkUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.toUiModel

data class MeasureResultUiModel(
    val headerStatus: String,
    val userName: String,
    val totalDrinkCountOfCup: Int,
    val averageAlcoholPercent: Double,
    val totalDrinkKcal: Int,
    val totalDrinkTime: String,
    val drinks: List<DrinkUiModel>,
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
        drinks = listOfNotNull(soju, beer, kaoliangju, wine, whisky).map { it.toUiModel() },
        extraGlasses = extraGlasses,
    )
}
