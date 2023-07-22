package com.mashup.alcoholfree.data.repository.measure

import com.mashup.alcoholfree.data.model.measure.MeasureResultDataModel
import com.mashup.alcoholfree.data.remote.measure.MeasureDataSource
import com.mashup.alcoholfree.domain.model.MeasureResult
import com.mashup.alcoholfree.domain.repository.measure.MeasureRepository
import javax.inject.Inject

class MeasureRepositoryImpl @Inject constructor(
    private val measureDataSource: MeasureDataSource,
) : MeasureRepository {
    override suspend fun getMeasureResult(reportId: String): MeasureResult {
        return MeasureResultDataModel.toDomainModel(
            measureDataSource.getMeasureResult(reportId),
        )
    }
}
