package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName
import com.mashup.alcoholfree.domain.model.DrinkInfo

data class DrinkInfoResponse(
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("text")
    val text: String,
) {
    fun toDomainModel(): DrinkInfo {
        return DrinkInfo(
            imageUrl = imageUrl,
            text = text,
        )
    }
}
