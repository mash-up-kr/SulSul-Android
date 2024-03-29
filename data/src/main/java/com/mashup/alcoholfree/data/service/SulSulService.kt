package com.mashup.alcoholfree.data.service

import com.mashup.alcoholfree.data.dto.remote.request.AlcoholLimitRequest
import com.mashup.alcoholfree.data.dto.remote.request.MeasureResultReportRequest
import com.mashup.alcoholfree.data.dto.remote.request.RegisterTierRequest
import com.mashup.alcoholfree.data.dto.remote.response.AlcoholLimitResponse
import com.mashup.alcoholfree.data.dto.remote.response.MeasureResultReportResponse
import com.mashup.alcoholfree.data.dto.remote.response.MeasureResultResponse
import com.mashup.alcoholfree.data.dto.remote.response.MyInfoResponse
import com.mashup.alcoholfree.data.dto.remote.response.PromiseCardsResponse
import com.mashup.alcoholfree.data.dto.remote.response.RegisterDrinkingLimitResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SulSulService {
    /**
     * 측정 결과 리포트 조회
     */
    @GET("/api/v1/drinkingReport/{reportId}")
    fun getMeasuringResult(
        @Path("reportId") reportId: String,
    ): Call<MeasureResultResponse>

    /**
     * 측정 결과 리포트 생성
     */
    @POST("/api/v1/drinkingReport")
    fun requestMeasureResultReport(
        @Body resultReport: MeasureResultReportRequest,
    ): Call<MeasureResultReportResponse>

    /**
     *  술약속 카드 조회
     */
    @GET("/api/v1/drinkingReport")
    fun getPromiseCardsResponse(): Call<PromiseCardsResponse>

    /**
     *  내정보 조회
     */
    @GET("/api/v1/user/me")
    fun getMyInfo(): Call<MyInfoResponse>

    /**
     * 주량 등록
     */
    @POST("/api/v1/drinkingLimit")
    fun registerDrinkingLimit(
        @Body registerTierRequest: RegisterTierRequest,
    ): Call<RegisterDrinkingLimitResponse>

    /**
     *  주량 측정 클릭 이벤트, 본인 주량 요청
     */
    @POST("/api/v1/drinkingReport/click-event")
    fun requestAlcoholLimit(
        @Body consumeAlcohol: AlcoholLimitRequest,
    ): Call<AlcoholLimitResponse>
}
