package com.mashup.alcoholfree.data.repository

import com.mashup.alcoholfree.data.datasource.PromiseDataSource
import com.mashup.alcoholfree.domain.model.PromiseCard
import com.mashup.alcoholfree.domain.repository.PromiseRepository
import javax.inject.Inject

class PromiseRepositoryImpl @Inject constructor(
    private val dataSource: PromiseDataSource,
) : PromiseRepository {
    override suspend fun getPromiseCards(): List<PromiseCard> {
        return dataSource.getPromiseCards().cards.map { card ->
            card.toDomainModel()
        }
    }
}
