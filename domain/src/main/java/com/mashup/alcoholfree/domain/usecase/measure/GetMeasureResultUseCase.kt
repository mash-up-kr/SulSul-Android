package com.mashup.alcoholfree.domain.usecase.measure

import com.mashup.alcoholfree.domain.model.MeasureResultDomainModel
import com.mashup.alcoholfree.domain.repository.measure.MeasureRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetMeasureResultUseCase @Inject constructor(
    private val measureRepository: MeasureRepository,
) {
    suspend operator fun invoke(reportId: String): MeasureResultDomainModel {
        return measureRepository.getMeasureResult(reportId)
    }
}
