package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.Drink

data class DrinkResponse(
    @SerializedName("drinkType")
    val drinkType: String,
    @SerializedName("glasses")
    val glasses: Int,
) {
    fun toDomainModel(): Drink {
        return Drink(
            drinkType = drinkType,
            glasses = glasses,
        )
    }
}
