package com.mashup.alcoholfree.presentation.ui.measuring.model

import com.mashup.alcoholfree.presentation.utils.ImmutableList

data class MeasuringState(
    val totalCount: Int,
    val records: String,
    val level: String,
    val currentAlcoholId: Int,
    val alcoholTypes: ImmutableList<String>,
    val isLoading: Boolean,
)
