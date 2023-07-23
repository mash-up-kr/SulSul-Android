package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.repository.TierRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetTierSubTitleUseCase @Inject constructor(
    private val tierRepository: TierRepository,
) {
    suspend operator fun invoke(): List<String> {
        return tierRepository.getTiers().map { it.subTitleText }
    }
}
