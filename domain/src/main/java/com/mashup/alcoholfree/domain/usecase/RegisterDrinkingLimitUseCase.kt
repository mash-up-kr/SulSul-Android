package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.base.BaseUseCase
import com.mashup.alcoholfree.domain.base.Result
import com.mashup.alcoholfree.domain.model.RegisterTierParam
import com.mashup.alcoholfree.domain.repository.MyInfoRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class RegisterDrinkingLimitUseCase @Inject constructor(
    private val myInfoRepository: MyInfoRepository,
) : BaseUseCase() {
    suspend operator fun invoke(registerTierParam: RegisterTierParam): Result<String> = execute {
        myInfoRepository.registerDrinkingLimit(registerTierParam)
    }
}
