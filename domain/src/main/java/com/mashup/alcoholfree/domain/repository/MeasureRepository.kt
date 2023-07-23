package com.mashup.alcoholfree.domain.repository

import com.mashup.alcoholfree.domain.model.MeasureResult

interface MeasureRepository {
    suspend fun getMeasureResult(reportId: String): MeasureResult
}
