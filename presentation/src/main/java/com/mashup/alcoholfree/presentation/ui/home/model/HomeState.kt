package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.presentation.utils.ImmutableList

data class HomeState(
    val userName: String,
    val alcoholTier: TierUiModel?,
    val drinkLimit: DrinkUiModel?,
    val cardList: ImmutableList<AlcoholPromiseCardState>,
    val isLoading: Boolean = false,
) {
    val isTierEmpty: Boolean get() = alcoholTier == null
    val isCardListEmpty: Boolean get() = cardList.list.isEmpty()
}
