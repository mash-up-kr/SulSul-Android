package com.mashup.alcoholfree.data.repository

import com.mashup.alcoholfree.data.datasource.MyInfoDataSource
import com.mashup.alcoholfree.data.dto.remote.request.toRequestModel
import com.mashup.alcoholfree.domain.model.MyInfo
import com.mashup.alcoholfree.domain.model.RegisterTierParam
import com.mashup.alcoholfree.domain.repository.MyInfoRepository
import javax.inject.Inject

class MyInfoRepositoryImpl @Inject constructor(
    private val myInfoDataSource: MyInfoDataSource,
) : MyInfoRepository {
    override suspend fun getMyInfo(): MyInfo {
        return myInfoDataSource
            .getMyInfo()
            .toDomainModel()
    }

    override suspend fun registerDrinkingLimit(registerTierParam: RegisterTierParam): String {
        return myInfoDataSource
            .registerDrinkingLimit(registerTierParam.toRequestModel()).tier
    }
}
