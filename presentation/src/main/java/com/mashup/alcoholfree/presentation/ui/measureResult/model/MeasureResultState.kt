package com.mashup.alcoholfree.presentation.ui.measureResult.model

data class MeasureResultState(
    val headerStatus: String,
    val userName: String,
    val overDrinkSojuCount: Int,
    val totalDrinkCountOfCup: Int,
    val totalDrinkKcal: Int,
    val totalDrinkAlcohol: Float,
    val totalDrinkTime: String,
    val drinkCountOfSoju: Int,
    val drinkCountOfBeer: Int,
    val drinkCountOfKaoliangju: Int,
    val drinkCountOfWine: Int,
)
