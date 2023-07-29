package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.presentation.utils.ImmutableList

data class AlcoholPromiseCardState(
    val reportId: String,
    val cardType: AlcoholPromiseCardType,
    val drinks: ImmutableList<DrinkUiModel>,
    val drankDate: String,
    val subTitleText: String,
)
