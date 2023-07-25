package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.presentation.utils.ImmutableList

data class HomeState(
    val userName: String,
    val alcoholTier: AlcoholTier,
    val cardList: ImmutableList<AlcoholPromiseCardState>,
) {
    val isCardListEmpty: Boolean get() = cardList.list.isEmpty()
}
