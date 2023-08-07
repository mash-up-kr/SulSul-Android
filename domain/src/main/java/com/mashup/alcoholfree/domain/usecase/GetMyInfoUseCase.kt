package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.base.BaseUseCase
import com.mashup.alcoholfree.domain.base.Result
import com.mashup.alcoholfree.domain.model.MyInfo
import com.mashup.alcoholfree.domain.repository.MyInfoRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetMyInfoUseCase @Inject constructor(
    private val myInfoRepository: MyInfoRepository,
) : BaseUseCase() {
    suspend operator fun invoke(): Result<MyInfo> = execute {
        myInfoRepository.getMyInfo()
    }
}
