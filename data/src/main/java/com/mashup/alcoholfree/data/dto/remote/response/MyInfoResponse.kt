package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.MyInfo

data class MyInfoResponse(
    @SerializedName("drinkingLimits")
    val drinkingLimits: List<DrinkingLimitResponse>?,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("title")
    val title: TierResponse?,
) {
    fun toDomainModel(): MyInfo {
        return MyInfo(
            nickname = nickname,
            tier = title?.toDomainModel(),
            drinkingLimits = drinkingLimits
                ?.first()
                ?.toDomainModel(),
        )
    }
}
