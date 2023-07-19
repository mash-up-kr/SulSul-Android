package com.mashup.alcoholfree.presentation.ui.home.model

data class HomeState(
    val userName: String,
    val alcoholLevel: AlcoholLevel,
    val cardList: List<AlcoholPromiseCardState>,
)
