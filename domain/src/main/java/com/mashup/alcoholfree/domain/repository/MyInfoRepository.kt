package com.mashup.alcoholfree.domain.repository

import com.mashup.alcoholfree.domain.model.MyInfo
import com.mashup.alcoholfree.domain.model.RegisterTierParam
import kotlinx.coroutines.flow.Flow

interface MyInfoRepository {
    fun getMyInfo(): Flow<MyInfo>
    suspend fun registerDrinkingLimit(registerTierParam: RegisterTierParam): String
}
