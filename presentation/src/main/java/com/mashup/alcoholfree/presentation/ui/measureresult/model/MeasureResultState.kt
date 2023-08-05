package com.mashup.alcoholfree.presentation.ui.measureresult.model

import com.mashup.alcoholfree.presentation.ui.home.model.DrinkUiModel
import com.mashup.alcoholfree.presentation.utils.ImmutableList

data class MeasureResultState(
    val headerStatus: String,
    val userName: String,
    val totalDrinkCountOfCup: Int,
    val averageAlcoholPercent: Double,
    val totalDrinkKcal: Int,
    val totalDrinkTime: String,
    val drinks: ImmutableList<DrinkUiModel>,
    val extraGlasses: Int,
    val isLoading: Boolean = false,
)
