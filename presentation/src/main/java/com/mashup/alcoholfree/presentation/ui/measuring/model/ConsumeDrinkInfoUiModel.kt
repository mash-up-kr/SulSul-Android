package com.mashup.alcoholfree.presentation.ui.measuring.model

import com.mashup.alcoholfree.domain.model.ConsumeDrinkInfo

data class ConsumeDrinkInfoUiModel(
    val isDrunken: Boolean,
    val title: DrinkInfoUiModel,
)

fun ConsumeDrinkInfo.toUiModel(): ConsumeDrinkInfoUiModel {
    return ConsumeDrinkInfoUiModel(
        isDrunken = isDrunken,
        title = title.toUiModel(),
    )
}
