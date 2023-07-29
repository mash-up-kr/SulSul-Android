package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.domain.model.Drink

data class DrinkUiModel(
    val alcoholType: String,
    val glasses: Int,
)

fun Drink.toUiModel(): DrinkUiModel {
    return DrinkUiModel(
        alcoholType = drinkType,
        glasses = glasses,
    )
}

fun DrinkUiModel.toDomainModel(): Drink {
    return Drink(
        drinkType = alcoholType,
        glasses = glasses,
    )
}
