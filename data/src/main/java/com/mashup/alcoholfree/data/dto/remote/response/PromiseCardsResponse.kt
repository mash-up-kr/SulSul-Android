package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.PromiseCard

data class PromiseCardsResponse(
    @SerializedName("cards")
    val cards: List<CardResponse>
)

data class CardResponse(
    @SerializedName("cards")
    val drinkingReportId: String,
    @SerializedName("cardImageUrl")
    val cardImageUrl: String,
    @SerializedName("drinks")
    val drinks: List<DrinkResponse>,
    @SerializedName("drankDate")
    val drankDate: String,
    @SerializedName("subTitleText")
    val subTitleText: String,
) {
    fun toDomainModel() = PromiseCard(
        reportId = drinkingReportId,
        drinks = drinks.map { it.toDomainModel() },
        drankDate = drankDate,
        subTitleText = subTitleText,
    )
}
