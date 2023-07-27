package com.mashup.alcoholfree.presentation.ui.measureresult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.usecase.CreateMeasureResultReportUseCase
import com.mashup.alcoholfree.domain.usecase.GetMeasureResultUseCase
import com.mashup.alcoholfree.presentation.ui.home.model.DrinkUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.MeasureResultReportParamUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.toDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeasureResultViewModel @Inject constructor(
    private val getMeasureResultUseCase: GetMeasureResultUseCase,
    private val createMeasureResultReportUseCase: CreateMeasureResultReportUseCase,
) : ViewModel() {
    fun getMeasureResultReport() {
        viewModelScope.launch {
            getMeasureResultUseCase("reportId")
        }
    }

    fun createMeasureResultReport() {
        viewModelScope.launch {
            createMeasureResultReportUseCase(
                MeasureResultReportParamUiModel(
                    drinkingEndTime = "2023-07-24T12:45:44.002Z",
                    drinkingStartTime = "2023-07-24T12:45:44.002Z",
                    drinks = listOf(DrinkUiModel("소주", 2), DrinkUiModel("맥주", 1)),
                    totalDrinkGlasses = 12,
                )
                    .toDomainModel(),
            )
        }
    }
}
