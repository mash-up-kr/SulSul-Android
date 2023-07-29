package com.mashup.alcoholfree.data.datasource

import com.mashup.alcoholfree.data.dto.remote.response.PromiseCardsResponse
import com.mashup.alcoholfree.data.service.SulSulService
import retrofit2.await
import javax.inject.Inject

class PromiseDataSource @Inject constructor(
    private val sulSulService: SulSulService,
) {
    suspend fun getPromiseCards(): PromiseCardsResponse {
        return sulSulService.getPromiseCardsResponse().await()
    }
}
