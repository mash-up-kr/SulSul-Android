package com.mashup.alcoholfree.presentation.ui.measureresult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.usecase.GetMeasureResultUseCase
import com.mashup.alcoholfree.presentation.ui.home.model.DrinkUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.MeasureResultReportParamUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.toDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeasureResultViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMeasureResultUseCase: GetMeasureResultUseCase,
    private val createMeasureResultReportUseCase: CreateMeasureResultReportUseCase,
) : ViewModel() {
    fun getMeasureResultReport() {
        viewModelScope.launch {
            getMeasureResultUseCase(reportId)
        }
    }
}
