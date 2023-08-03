package com.mashup.alcoholfree.presentation.ui.measuring.model

import com.mashup.alcoholfree.domain.model.DrinkInfo

data class DrinkInfoUiModel(
    val imageUrl: String,
    val text: String,
)

fun DrinkInfo.toUiModel(): DrinkInfoUiModel {
    return DrinkInfoUiModel(
        imageUrl = imageUrl,
        text = text,
    )
}
