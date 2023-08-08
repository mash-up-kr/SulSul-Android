package com.mashup.alcoholfree.presentation.ui.measureresult

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.base.Result
import com.mashup.alcoholfree.domain.model.MeasureResult
import com.mashup.alcoholfree.domain.usecase.GetMeasureResultUseCase
import com.mashup.alcoholfree.presentation.ui.measureresult.model.MeasureResultState
import com.mashup.alcoholfree.presentation.ui.measureresult.model.MeasureResultUiModel
import com.mashup.alcoholfree.presentation.ui.measureresult.model.toUiModel
import com.mashup.alcoholfree.presentation.utils.ImmutableList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeasureResultViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMeasureResultUseCase: GetMeasureResultUseCase,
) : ViewModel() {

    private val reportId = savedStateHandle.get<String>("reportId")

    private val _state = MutableStateFlow(initState())
    val state = _state.asStateFlow()

    private val _errorEvent = MutableLiveData<Unit>()
    val errorEvent: LiveData<Unit> = _errorEvent

    init {
        reportId?.let { id ->
            viewModelScope.launch {
                _state.update { state ->
                    state.copy(
                        isLoading = true,
                    )
                }

                val measureResultUiModel: MeasureResultUiModel? =
                    handleMeasureResultUseCase(getMeasureResultUseCase(id))

                measureResultUiModel?.let { uiModel ->
                    _state.update { state ->
                        state.copy(
                            headerStatus = uiModel.headerStatus,
                            totalDrinkCountOfCup = uiModel.totalDrinkCountOfCup,
                            totalDrinkKcal = uiModel.totalDrinkKcal,
                            totalDrinkTime = uiModel.totalDrinkTime,
                            drinks = ImmutableList(uiModel.drinks),
                            extraGlasses = uiModel.extraGlasses,
                            averageAlcoholPercent = uiModel.averageAlcoholPercent,
                            isLoading = false,
                        )
                    }
                } ?: run {
                    _errorEvent.value = Unit
                }
            }
        }
    }

    private fun handleMeasureResultUseCase(result: Result<MeasureResult>): MeasureResultUiModel? {
        return when (result) {
            is Result.Success -> result.value.toUiModel()
            is Result.Error -> null
        }
    }

    private fun initState(): MeasureResultState {
        return MeasureResultState(
            headerStatus = "미쳤따",
            userName = "회원",
            averageAlcoholPercent = 0.0,
            totalDrinkCountOfCup = 0,
            totalDrinkKcal = 0,
            totalDrinkTime = "",
            drinks = ImmutableList(emptyList()),
            extraGlasses = 0,
        )
    }
}
