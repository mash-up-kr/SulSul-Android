package com.mashup.alcoholfree.data.dto.remote.request

import com.mashup.alcoholfree.domain.model.Drink

data class DrinkRequest(
    val drinkType: String,
    val glasses: Int,
)

fun Drink.toRequestModel(): DrinkRequest {
    return DrinkRequest(
        drinkType = drinkType,
        glasses = glasses,
    )
}
