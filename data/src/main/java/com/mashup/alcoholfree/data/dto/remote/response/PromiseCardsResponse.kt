package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.PromiseCard

data class PromiseCardsResponse(
    @SerializedName("cards")
    val cards: List<CardResponse>
)

data class CardResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("totalAlcoholAmount")
    val totalAlcoholAmount: Double,
    @SerializedName("totalDrinkGlasses")
    val totalDrinkGlasses: Int,
    @SerializedName("drinks")
    val drinks: List<DrinkResponse>,
    @SerializedName("drankAt")
    val drankAt: String,
) {
    fun toDomainModel() = PromiseCard(
        reportId = id,
        cardType = drinks.first().drinkType,
        drinks = drinks.map { it.toDomainModel() },
        drankDate = drankAt,
    )
}
