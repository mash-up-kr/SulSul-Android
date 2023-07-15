package com.mashup.alcoholfree.presentation.ui.measuring.model

data class MeasuringState(
    val totalCount: Int,
    val records: String,
    val level: String,
    val currentAlcoholId: Int,
    val alcoholTypes: List<String>,
)
