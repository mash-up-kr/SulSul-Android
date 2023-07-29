package com.mashup.alcoholfree.data.datasource

import com.mashup.alcoholfree.data.dto.remote.response.MyInfoResponse
import com.mashup.alcoholfree.data.service.SulSulService
import retrofit2.await
import javax.inject.Inject

class MyInfoDataSource @Inject constructor(
    private val sulSulService: SulSulService,
) {
    suspend fun getMyInfo(): MyInfoResponse {
        return sulSulService.getMyInfo().await()
    }
}
