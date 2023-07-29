package com.mashup.alcoholfree.domain.repository

import com.mashup.alcoholfree.domain.model.MyInfo

interface MyInfoRepository {
    suspend fun getMyInfo(): MyInfo
}
