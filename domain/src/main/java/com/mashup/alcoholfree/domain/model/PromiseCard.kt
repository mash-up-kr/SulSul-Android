package com.mashup.alcoholfree.domain.model

data class PromiseCard(
    val reportId: String,
    val cardType: String,
    val drinks: List<Drink>,
    val drankDate: String,
    val tier: String,
)
