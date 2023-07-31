package com.mashup.alcoholfree.presentation.ui.measureresult.model

data class MeasureResultState(
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
