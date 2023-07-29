package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.domain.model.Tier

data class TierUiModel(
    val subTitle: String,
    val title: String,
    val tierImageUrl: String,
)

fun Tier.toUiModel(): TierUiModel {
    return TierUiModel(
        subTitle = subTitle,
        title = title,
        tierImageUrl = tierImageUrl,
    )
}
