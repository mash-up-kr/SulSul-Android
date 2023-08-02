package com.mashup.alcoholfree.data.dto.remote.request

import com.mashup.alcoholfree.domain.model.Drink

data class ConsumeDrinkRequest(
    val drinkType: String,
    val glass: Int,
)

fun Drink.toRequestConsumeDrinkModel() = ConsumeDrinkRequest(
    drinkType = drinkType,
    glass = glasses,
)
