package com.mashup.alcoholfree.data.datasource

import com.mashup.alcoholfree.data.dto.remote.request.MeasureResultReportRequest
import com.mashup.alcoholfree.data.dto.remote.response.MeasureResultReportResponse
import com.mashup.alcoholfree.data.dto.remote.response.MeasureResultResponse
import com.mashup.alcoholfree.data.service.SulSulService
import retrofit2.await
import javax.inject.Inject

class MeasureDataSource @Inject constructor(
    private val sulSulService: SulSulService,
) {
    suspend fun getMeasureResult(reportId: String): MeasureResultResponse {
        return sulSulService
            .getMeasuringResult(reportId)
            .await()
    }

    suspend fun createMeasureResultReport(resultReport: MeasureResultReportRequest): MeasureResultReportResponse {
        return sulSulService
            .requestMeasureResultReport(resultReport)
            .await()
    }
}
