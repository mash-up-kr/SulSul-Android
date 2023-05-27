package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.repository.LoginRepository
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Reusable
class GetTokenUseCase @Inject constructor(
    private val dataStoreRepository: LoginRepository,
) {
    operator fun invoke(): Flow<String> {
        return dataStoreRepository.getToken()
    }
}
