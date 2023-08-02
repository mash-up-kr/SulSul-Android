package com.mashup.alcoholfree.domain.repository

import com.mashup.alcoholfree.domain.model.AlcoholLimitParam
import com.mashup.alcoholfree.domain.model.ConsumeDrinkInfo
import com.mashup.alcoholfree.domain.model.MeasureResult
import com.mashup.alcoholfree.domain.model.MeasureResultReportId
import com.mashup.alcoholfree.domain.model.MeasureResultReportParam

interface MeasureRepository {
    suspend fun getMeasureResult(reportId: String): MeasureResult
    suspend fun createMeasureResultReport(resultReport: MeasureResultReportParam): MeasureResultReportId
    suspend fun getAlcoholLimit(consumeAlcohol: AlcoholLimitParam): ConsumeDrinkInfo
}
