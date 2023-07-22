package com.mashup.alcoholfree.data.remote.measure

import com.mashup.alcoholfree.data.remote.response.MeasureResultResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MeasureService {
    @GET("/api/v1/drinkingReport/")
    fun getMeasuringResult(
        @Query("reportId") reportId: String,
    ): Call<MeasureResultResponse>
}
