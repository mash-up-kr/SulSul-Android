package com.mashup.alcoholfree.data.repository

import com.mashup.alcoholfree.data.datasource.MeasureDataSource
import com.mashup.alcoholfree.data.dto.remote.request.toRequestModel
import com.mashup.alcoholfree.domain.model.MeasureResult
import com.mashup.alcoholfree.domain.model.MeasureResultReportId
import com.mashup.alcoholfree.domain.model.MeasureResultReportParam
import com.mashup.alcoholfree.domain.repository.MeasureRepository
import javax.inject.Inject

class MeasureRepositoryImpl @Inject constructor(
    private val measureDataSource: MeasureDataSource,
) : MeasureRepository {
    override suspend fun getMeasureResult(reportId: String): MeasureResult {
        return measureDataSource
            .getMeasureResult(reportId)
            .toDomainModel()
    }

    override suspend fun createMeasureResultReport(resultReport: MeasureResultReportParam): MeasureResultReportId {
        return MeasureResultReportId(
            measureDataSource
                .createMeasureResultReport(resultReport.toRequestModel())
                .id,
        )
    }
}
