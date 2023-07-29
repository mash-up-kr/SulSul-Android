package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.Drink

data class DrinkingLimitResponse(
    @SerializedName("glass")
    val glass: Int,
    @SerializedName("type")
    val type: String,
) {
    fun toDomainModel(): Drink {
        return Drink(
            glasses = glass,
            drinkType = type,
        )
    }
}
