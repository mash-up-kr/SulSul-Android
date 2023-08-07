package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.base.BaseUseCase
import com.mashup.alcoholfree.domain.base.Result
import com.mashup.alcoholfree.domain.model.PromiseCard
import com.mashup.alcoholfree.domain.repository.PromiseRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetAlcoholPromiseCardsUseCase @Inject constructor(
    private val promiseRepository: PromiseRepository,
) : BaseUseCase() {
    suspend operator fun invoke(): Result<List<PromiseCard>> = execute {
        promiseRepository.getPromiseCards()
    }
}
