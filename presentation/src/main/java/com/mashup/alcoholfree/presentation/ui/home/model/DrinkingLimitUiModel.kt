package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.domain.model.DrinkingLimit

data class DrinkingLimitUiModel(
    val glass: Int,
    val type: String,
)

fun DrinkingLimit.toUiModel(): DrinkingLimitUiModel {
    return DrinkingLimitUiModel(
        glass = glass,
        type = type,
    )
}
