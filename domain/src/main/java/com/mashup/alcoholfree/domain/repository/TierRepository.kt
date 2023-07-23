package com.mashup.alcoholfree.domain.repository

import com.mashup.alcoholfree.domain.model.AlcoholTier

interface TierRepository {
    suspend fun getTiers(): List<AlcoholTier>
}
