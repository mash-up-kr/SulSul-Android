package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.base.BaseUseCase
import com.mashup.alcoholfree.domain.base.Result
import com.mashup.alcoholfree.domain.model.MeasureResultReportId
import com.mashup.alcoholfree.domain.model.MeasureResultReportParam
import com.mashup.alcoholfree.domain.repository.MeasureRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class CreateMeasureResultReportUseCase @Inject constructor(
    private val measureRepository: MeasureRepository,
) : BaseUseCase() {
    suspend operator fun invoke(resultReport: MeasureResultReportParam): Result<MeasureResultReportId> =
        execute {
            measureRepository.createMeasureResultReport(resultReport)
        }
}
