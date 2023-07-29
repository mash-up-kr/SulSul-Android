package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.domain.model.MyInfo

data class MyInfoUiModel(
    val drinkingLimits: List<DrinkingLimitUiModel>?,
    val nickname: String,
    val tier: TierUiModel?,
)

fun MyInfo.toUiModel(): MyInfoUiModel {
    return MyInfoUiModel(
        drinkingLimits = drinkingLimits?.map { it.toUiModel() },
        nickname = nickname,
        tier = tier?.toUiModel(),
    )
}
