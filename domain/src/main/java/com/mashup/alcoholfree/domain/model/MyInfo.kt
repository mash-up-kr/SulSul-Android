package com.mashup.alcoholfree.domain.model

data class MyInfo(
    val nickname: String,
    val tier: Tier?,
    val drinkingLimits: Drink?,
)
