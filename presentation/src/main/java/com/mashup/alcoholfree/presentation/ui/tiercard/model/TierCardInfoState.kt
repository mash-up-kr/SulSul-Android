package com.mashup.alcoholfree.presentation.ui.tiercard.model

import com.mashup.alcoholfree.presentation.ui.home.model.DrinkUiModel

data class TierCardInfoState(
    val isLoading: Boolean,
    val drinkLimit: DrinkUiModel,
)
