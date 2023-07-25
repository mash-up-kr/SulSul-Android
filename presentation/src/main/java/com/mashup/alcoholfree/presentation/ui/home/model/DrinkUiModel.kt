package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.domain.model.Drink

data class DrinkUiModel(
    val alcoholType: String,
    val glasses: Int,
)

fun DrinkUiModel.toDomainModel() = Drink(
    drinkType = alcoholType,
    glasses = glasses,
)
