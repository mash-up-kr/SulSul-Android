package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.Drink

data class DrinkResponse(
    @SerializedName("drinkType")
    val drinkType: String,
    @SerializedName("glasses")
    val glasses: Int,
) {
    companion object {
        fun toDomainModel(response: DrinkResponse): Drink {
            return Drink(
                drinkType = response.drinkType,
                glasses = response.glasses,
            )
        }
    }
}
