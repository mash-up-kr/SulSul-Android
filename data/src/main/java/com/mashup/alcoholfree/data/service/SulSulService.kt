package com.mashup.alcoholfree.data.service

import com.mashup.alcoholfree.data.dto.TiersResponse
import retrofit2.http.GET

internal interface SulSulService {
    @GET("api/v1/title")
    fun getSulSulTiers(): TiersResponse
}
