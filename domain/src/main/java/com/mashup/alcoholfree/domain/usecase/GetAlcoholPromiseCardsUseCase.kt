package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.model.PromiseCard
import com.mashup.alcoholfree.domain.repository.PromiseRepository
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Reusable
class GetAlcoholPromiseCardsUseCase @Inject constructor(
    private val promiseRepository: PromiseRepository,
) {
    operator fun invoke(): Flow<List<PromiseCard>> {
        return promiseRepository.getPromiseCards()
    }
}
