package com.mashup.alcoholfree.data.dto

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.AlcoholTier

internal data class TiersResponse(
    @SerializedName("titles") val titles: List<TierResponse>
)

internal data class TierResponse(
    @SerializedName("titleText") val titleText: String,
    @SerializedName("subTitleText") val subTitleText: String,
    @SerializedName("badgeImageUrl") val badgeImageUrl: String,
    @SerializedName("cardImageUrl") val cardImageUrl: String,
    @SerializedName("alcoholAmount") val alcoholAmount: Float,
) {
    fun toDomainModel(): AlcoholTier {
        return AlcoholTier(
            titleText = titleText,
            subTitleText = subTitleText,
            badgeImageUrl = badgeImageUrl,
            cardImageUrl = cardImageUrl,
            alcoholAmount = alcoholAmount,
        )
    }
}
