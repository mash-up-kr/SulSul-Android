package com.mashup.alcoholfree.data.repository

import com.mashup.alcoholfree.data.service.SulSulService
import com.mashup.alcoholfree.domain.model.AlcoholTier
import com.mashup.alcoholfree.domain.repository.TierRepository
import javax.inject.Inject

internal class TierRepositoryImpl @Inject constructor(
    private val sulSulService: SulSulService,
): TierRepository {
    override fun getTiers(): List<AlcoholTier> {
        return sulSulService.getSulSulTiers().titles.map {
            it.toDomainModel()
        }
    }
}
