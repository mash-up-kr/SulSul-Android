package com.mashup.alcoholfree.data.dto.remote.response

import com.google.gson.annotations.SerializedName

data class PromiseCardsResponse(
    @SerializedName("cards")
    val cards: List<CardResponse>
)
