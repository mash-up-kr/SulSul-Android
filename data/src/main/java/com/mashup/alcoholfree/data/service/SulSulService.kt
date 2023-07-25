package com.mashup.alcoholfree.data.service

import com.mashup.alcoholfree.data.dto.remote.response.MeasureResultResponse
import com.mashup.alcoholfree.data.dto.remote.response.PromiseCardsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SulSulService {
    /**
     * 측정 결과 리포트 조회
     */
    @GET("/api/v1/drinkingReport/")
    fun getMeasuringResult(
        @Query("reportId") reportId: String,
    ): Call<MeasureResultResponse>

    /**
     *  술약속 카드 조회
     */
    @GET("/api/v1/drinkingReport")
    fun getPromiseCardsResponse(): Call<PromiseCardsResponse>
}
