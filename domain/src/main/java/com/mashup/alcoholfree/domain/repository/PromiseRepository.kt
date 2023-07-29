package com.mashup.alcoholfree.domain.repository

import com.mashup.alcoholfree.domain.model.PromiseCard

interface PromiseRepository {
    suspend fun getPromiseCards(): List<PromiseCard>
}
