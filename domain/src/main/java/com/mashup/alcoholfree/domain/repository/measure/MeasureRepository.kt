package com.mashup.alcoholfree.domain.repository.measure

import com.mashup.alcoholfree.domain.model.MeasureResultDomainModel

interface MeasureRepository {
    suspend fun getMeasureResult(reportId: String): MeasureResultDomainModel
}
