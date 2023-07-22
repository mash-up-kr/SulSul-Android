package com.mashup.alcoholfree.data.remote.response

import com.google.gson.annotations.SerializedName

data class DrinkResponse(
    @SerializedName("drinkType")
    val drinkType: String,
    @SerializedName("glasses")
    val glasses: Int,
)
