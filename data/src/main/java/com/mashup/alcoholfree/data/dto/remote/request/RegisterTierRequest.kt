package com.mashup.alcoholfree.data.dto.remote.request

import com.mashup.alcoholfree.domain.model.RegisterTierParam

data class RegisterTierRequest(
    val drinkType: String,
    val glass: Int,
)

fun RegisterTierParam.toRequestModel(): RegisterTierRequest {
    return RegisterTierRequest(
        drinkType = drinkType,
        glass = glass,
    )
}
