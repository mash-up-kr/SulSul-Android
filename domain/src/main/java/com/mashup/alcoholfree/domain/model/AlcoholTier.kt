package com.mashup.alcoholfree.domain.model

data class AlcoholTier(
    val titleText: String,
    val subTitleText: String,
    val badgeImageUrl: String,
    val cardImageUrl: String,
    val alcoholAmount: Float,
)
