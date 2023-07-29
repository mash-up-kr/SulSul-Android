package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.DrinkingLimit

data class DrinkingLimitResponse(
    @SerializedName("glass")
    val glass: Int,
    @SerializedName("type")
    val type: String,
) {
    fun toDomainModel(): DrinkingLimit {
        return DrinkingLimit(
            glass = glass,
            type = type,
        )
    }
}
