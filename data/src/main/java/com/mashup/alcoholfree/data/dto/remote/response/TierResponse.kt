package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.Tier

data class TierResponse(
    @SerializedName("subTitle")
    val subTitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("badgeImageUrl")
    val tierImageUrl: String,
) {
    fun toDomainModel(): Tier {
        return Tier(
            subTitle = subTitle,
            title = title,
            tierImageUrl = tierImageUrl,
        )
    }
}
