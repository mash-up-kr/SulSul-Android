package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.presentation.utils.ImmutableList

data class HomeState(
    val userName: String,
    val alcoholLevel: AlcoholLevel,
    val cardList: ImmutableList<AlcoholPromiseCardState>,
)
