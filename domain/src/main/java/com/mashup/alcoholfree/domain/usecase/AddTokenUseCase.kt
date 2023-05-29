package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.repository.LoginRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class AddTokenUseCase @Inject constructor(
    private val dataStoreRepository: LoginRepository,
) {
    suspend operator fun invoke(token: String) {
        return dataStoreRepository.addToken(token)
    }
}
