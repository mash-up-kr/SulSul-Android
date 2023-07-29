package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.model.MyInfo
import com.mashup.alcoholfree.domain.repository.MyInfoRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetMyInfoUseCase @Inject constructor(
    private val myInfoRepository: MyInfoRepository,
) {
    suspend operator fun invoke(): MyInfo {
        return myInfoRepository.getMyInfo()
    }
}
