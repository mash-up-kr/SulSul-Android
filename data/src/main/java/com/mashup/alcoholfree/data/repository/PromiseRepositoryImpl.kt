package com.mashup.alcoholfree.data.repository

import com.mashup.alcoholfree.data.datasource.PromiseDataSource
import com.mashup.alcoholfree.domain.model.PromiseCard
import com.mashup.alcoholfree.domain.repository.PromiseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PromiseRepositoryImpl @Inject constructor(
    private val dataSource: PromiseDataSource,
) : PromiseRepository {
    override fun getPromiseCards(): Flow<List<PromiseCard>> {
        return dataSource.getPromiseCards().map { response ->
            response.cards.map { card ->
                card.toDomainModel()
            }
        }
    }
}
