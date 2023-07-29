package com.mashup.alcoholfree.domain.model

data class MyInfo(
    val drinkingLimits: List<DrinkingLimit>?,
    val nickname: String,
    val tier: Tier?,
)
