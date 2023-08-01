package com.mashup.alcoholfree.presentation.ui.measureresult

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.usecase.GetMeasureResultUseCase
import com.mashup.alcoholfree.presentation.ui.measureresult.model.MeasureResultState
import com.mashup.alcoholfree.presentation.ui.measureresult.model.toUiModel
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

    init {
        reportId?.let { id ->
            viewModelScope.launch {
                val result = getMeasureResultUseCase(id).toUiModel()
                _state.update { state ->
                    state.copy(
                        headerStatus = result.headerStatus,
                        totalDrinkCountOfCup = result.totalDrinkCountOfCup,
                        totalDrinkKcal = result.totalDrinkKcal,
                        totalDrinkTime = result.totalDrinkTime,
                        drinkCountOfSoju = result.drinkCountOfSoju,
                        drinkCountOfBeer = result.drinkCountOfBeer,
                        drinkCountOfKaoliangju = result.drinkCountOfKaoliangju,
                        drinkCountOfWine = result.drinkCountOfWine,
                        drinkCountOfWhisky = result.drinkCountOfWhisky,
                        extraGlasses = result.extraGlasses,
                        averageAlcoholPercent = result.averageAlcoholPercent,
                    )
                }
            }
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
            drinkCountOfSoju = 0,
            drinkCountOfBeer = 0,
            drinkCountOfKaoliangju = 0,
            drinkCountOfWine = 0,
            drinkCountOfWhisky = 0,
            extraGlasses = 0,
        )
    }
}
