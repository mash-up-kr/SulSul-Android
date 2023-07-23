package com.mashup.alcoholfree.domain.model

data class PromiseCard(
    val reportId: String,
    val drinks: List<Drink>,
    val drankDate: String,
    val subTitleText: String,
)
