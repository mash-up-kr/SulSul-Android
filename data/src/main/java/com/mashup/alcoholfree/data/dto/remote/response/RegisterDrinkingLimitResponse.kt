package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName

data class RegisterDrinkingLimitResponse(
    @SerializedName("title")
    val tier: String,
)