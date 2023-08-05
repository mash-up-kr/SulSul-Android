package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.domain.model.MyInfo

data class MyInfoUiModel(
    val nickname: String,
    val tier: TierUiModel?,
    val drinkLimit: DrinkUiModel?,
)

fun MyInfo.toUiModel(): MyInfoUiModel {
    return MyInfoUiModel(
        nickname = nickname,
        tier = tier?.toUiModel(),
        drinkLimit = drinkingLimits?.toUiModel(),
    )
}
