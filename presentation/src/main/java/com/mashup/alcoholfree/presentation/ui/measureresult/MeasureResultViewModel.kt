package com.mashup.alcoholfree.presentation.ui.measureresult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.usecase.GetMeasureResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeasureResultViewModel @Inject constructor(
    private val getMeasureResultUseCase: GetMeasureResultUseCase,
) : ViewModel() {
    fun getMeasureResultReport() {
        viewModelScope.launch {
            getMeasureResultUseCase("reportId")
        }
    }
}
