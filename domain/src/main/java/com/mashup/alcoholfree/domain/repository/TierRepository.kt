package com.mashup.alcoholfree.domain.repository

import com.mashup.alcoholfree.domain.model.AlcoholTier

interface TierRepository {
    fun getTiers(): List<AlcoholTier>
}
