package com.mashup.alcoholfree.data.datasource

import com.mashup.alcoholfree.data.dto.remote.response.PromiseCardsResponse
import com.mashup.alcoholfree.data.service.SulSulService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.await
import javax.inject.Inject

class PromiseDataSource @Inject constructor(
    private val sulSulService: SulSulService,
) {
    fun getPromiseCards(): Flow<PromiseCardsResponse> {
        return flow {
            emit(sulSulService.getPromiseCardsResponse().await())
        }
    }
}
