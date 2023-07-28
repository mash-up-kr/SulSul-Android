package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.model.PromiseCard
import com.mashup.alcoholfree.domain.repository.PromiseRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetAlcoholPromiseCardsUseCase @Inject constructor(
    private val promiseRepository: PromiseRepository,
) {
    suspend operator fun invoke(): List<PromiseCard> {
        return promiseRepository.getPromiseCards()
    }
}
