package com.mashup.alcoholfree.data.dto.remote.request

import com.mashup.alcoholfree.domain.model.AlcoholLimitParam

data class AlcoholLimitRequest(
    val drinks: List<ConsumeDrinkRequest>,
)

fun AlcoholLimitParam.toRequestModel() = AlcoholLimitRequest(
    drinks = drinks.map { it.toRequestConsumeDrinkModel() },
)
