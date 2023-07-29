package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.model.RegisterTierParam
import com.mashup.alcoholfree.domain.repository.MyInfoRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class RegisterDrinkingLimitUseCase @Inject constructor(
    private val myInfoRepository: MyInfoRepository,
) {
    suspend operator fun invoke(registerTierParam: RegisterTierParam): String {
        return myInfoRepository.registerDrinkingLimit(registerTierParam)
    }
}
