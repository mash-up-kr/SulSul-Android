package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.base.BaseUseCase
import com.mashup.alcoholfree.domain.model.AlcoholLimitParam
import com.mashup.alcoholfree.domain.model.ConsumeDrinkInfo
import com.mashup.alcoholfree.domain.repository.MeasureRepository
import com.mashup.alcoholfree.domain.base.Result
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetAlcoholLimitUseCase @Inject constructor(
    private val measureRepository: MeasureRepository,
) : BaseUseCase() {
    suspend operator fun invoke(consumeAlcohol: AlcoholLimitParam): Result<ConsumeDrinkInfo> =
        execute {
            measureRepository.getAlcoholLimit(consumeAlcohol)
        }
}
