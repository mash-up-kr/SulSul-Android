package com.mashup.alcoholfree.data.datasource

import com.mashup.alcoholfree.data.dto.remote.response.MeasureResultResponse
import com.mashup.alcoholfree.data.service.SulSulService
import retrofit2.await
import javax.inject.Inject

internal class MeasureDataSource @Inject constructor(
    private val sulSulService: SulSulService,
) {
    suspend fun getMeasureResult(reportId: String): MeasureResultResponse {
        return sulSulService
            .getMeasuringResult(reportId)
            .await()
    }
}
