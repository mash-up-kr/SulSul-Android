package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.model.MeasureResult
import com.mashup.alcoholfree.domain.repository.MeasureRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetMeasureResultUseCase @Inject constructor(
    private val measureRepository: MeasureRepository,
) {
    suspend operator fun invoke(reportId: String): MeasureResult {
        return measureRepository.getMeasureResult(reportId)
    }
}
