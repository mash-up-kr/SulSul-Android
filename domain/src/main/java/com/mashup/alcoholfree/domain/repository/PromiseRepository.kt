package com.mashup.alcoholfree.domain.repository

import com.mashup.alcoholfree.domain.model.PromiseCard
import kotlinx.coroutines.flow.Flow

interface PromiseRepository {
    fun getPromiseCards(): Flow<List<PromiseCard>>
}
