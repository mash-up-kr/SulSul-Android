package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.ConsumeDrinkInfo

data class AlcoholLimitResponse(
    @SerializedName("isDrunken")
    val isDrunken: Boolean,
    @SerializedName("title")
    val title: DrinkInfoResponse,
) {
    fun toDomainModel(): ConsumeDrinkInfo {
        return ConsumeDrinkInfo(
            isDrunken = isDrunken,
            title = title.toDomainModel(),
        )
    }
}
