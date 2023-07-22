package com.mashup.alcoholfree.data.datasource

import com.mashup.alcoholfree.data.model.MeasureResultDataModel
import com.mashup.alcoholfree.data.service.SulSulService
import retrofit2.await
import javax.inject.Inject

class MeasureDataSource @Inject constructor(
    private val sulSulService: SulSulService,
) {
    suspend fun getMeasureResult(reportId: String): MeasureResultDataModel {
        return MeasureResultDataModel.toDataModel(
            sulSulService
                .getMeasuringResult(reportId)
                .await(),
        )
    }
}
