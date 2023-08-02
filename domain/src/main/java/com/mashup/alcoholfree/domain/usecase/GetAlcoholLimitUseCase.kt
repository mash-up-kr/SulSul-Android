package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.model.AlcoholLimitParam
import com.mashup.alcoholfree.domain.model.ConsumeDrinkInfo
import com.mashup.alcoholfree.domain.repository.MeasureRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetAlcoholLimitUseCase @Inject constructor(
    private val measureRepository: MeasureRepository,
) {
    suspend operator fun invoke(consumeAlcohol: AlcoholLimitParam): ConsumeDrinkInfo {
        return measureRepository.getAlcoholLimit(consumeAlcohol)
    }
}
