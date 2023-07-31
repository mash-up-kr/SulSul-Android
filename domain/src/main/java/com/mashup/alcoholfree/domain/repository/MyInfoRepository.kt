package com.mashup.alcoholfree.domain.repository

import com.mashup.alcoholfree.domain.model.MyInfo
import com.mashup.alcoholfree.domain.model.RegisterTierParam

interface MyInfoRepository {
    suspend fun getMyInfo(): MyInfo
    suspend fun registerDrinkingLimit(registerTierParam: RegisterTierParam): String
}
