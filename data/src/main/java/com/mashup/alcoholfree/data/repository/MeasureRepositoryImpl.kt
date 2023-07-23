package com.mashup.alcoholfree.data.repository

import com.mashup.alcoholfree.data.datasource.MeasureDataSource
import com.mashup.alcoholfree.data.dto.remote.response.MeasureResultResponse
import com.mashup.alcoholfree.domain.model.MeasureResult
import com.mashup.alcoholfree.domain.repository.MeasureRepository
import javax.inject.Inject

class MeasureRepositoryImpl @Inject constructor(
    private val measureDataSource: MeasureDataSource,
) : MeasureRepository {
    override suspend fun getMeasureResult(reportId: String): MeasureResult {
        return MeasureResultResponse.toDomainModel(
            measureDataSource.getMeasureResult(reportId),
        )
    }
}
