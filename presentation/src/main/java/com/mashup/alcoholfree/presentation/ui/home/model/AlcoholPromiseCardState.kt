package com.mashup.alcoholfree.presentation.ui.home.model

data class AlcoholPromiseCardState(
    val id: String,
    val cardType: AlcoholPromiseCardType,
    val drinks: String,
    val drankDate: String,
    val tier: String,
)
