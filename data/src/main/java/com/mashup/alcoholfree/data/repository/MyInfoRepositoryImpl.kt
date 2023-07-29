package com.mashup.alcoholfree.data.repository

import com.mashup.alcoholfree.data.service.SulSulService
import com.mashup.alcoholfree.domain.model.MyInfo
import com.mashup.alcoholfree.domain.repository.MyInfoRepository
import retrofit2.await
import javax.inject.Inject

class MyInfoRepositoryImpl @Inject constructor(
    private val sulService: SulSulService,
) : MyInfoRepository {
    override suspend fun getMyInfo(): MyInfo {
        return sulService
            .getMyInfo()
            .await()
            .toDomainModel()
    }
}
