package com.mashup.alcoholfree.data.remote.measure

import com.mashup.alcoholfree.data.model.measure.MeasureResultDataModel
import retrofit2.await
import javax.inject.Inject

class MeasureDataSource @Inject constructor(
    private val measureService: MeasureService,
) {
    suspend fun getMeasureResult(reportId: String): MeasureResultDataModel {
        return MeasureResultDataModel(
            measureService
                .getMeasuringResult(reportId)
                .await(),
        )
    }
}
