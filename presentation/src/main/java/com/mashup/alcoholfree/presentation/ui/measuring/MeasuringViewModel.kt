package com.mashup.alcoholfree.presentation.ui.measuring

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.base.Result
import com.mashup.alcoholfree.domain.model.ConsumeDrinkInfo
import com.mashup.alcoholfree.domain.usecase.CreateMeasureResultReportUseCase
import com.mashup.alcoholfree.domain.usecase.GetAlcoholLimitUseCase
import com.mashup.alcoholfree.presentation.ui.home.model.DrinkUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.MeasureResultReportParamUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.toDomainModel
import com.mashup.alcoholfree.presentation.ui.measuring.model.AlcoholLimitParamUiModel
import com.mashup.alcoholfree.presentation.ui.measuring.model.ConsumeDrinkInfoUiModel
import com.mashup.alcoholfree.presentation.ui.measuring.model.MeasuringState
import com.mashup.alcoholfree.presentation.ui.measuring.model.toDomainModel
import com.mashup.alcoholfree.presentation.ui.measuring.model.toUiModel
import com.mashup.alcoholfree.presentation.utils.Event
import com.mashup.alcoholfree.presentation.utils.ImmutableList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class MeasuringViewModel @Inject constructor(
    private val createMeasureResultReportUseCase: CreateMeasureResultReportUseCase,
    private val getAlcoholLimitUseCase: GetAlcoholLimitUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(initState())
    val state: StateFlow<MeasuringState>
        get() = _state

    private val _createReportSuccessEvent = MutableLiveData<Event<String>>()
    val createReportSuccessEvent: LiveData<Event<String>>
        get() = _createReportSuccessEvent

    private val drinkingStartTime = getDateTimeNow()
    private val drinkingMap = mutableMapOf<String, Int>()
    private val drinks
        get() = drinkingMap.toList()

    private fun getDateTimeNow() = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)

    fun addAlcoholItem(alcoholType: String) {
        drinkingMap[alcoholType] = (drinkingMap[alcoholType] ?: 0) + 1
        _state.update { state ->
            state.copy(
                totalCount = state.totalCount + 1,
                records = drinks.joinToString(" · ") { (alcoholType, glass) ->
                    "$alcoholType ${glass}잔"
                },
            )
        }
        getDrinkLimit()
    }

    fun createMeasureResultReport() {
        viewModelScope.launch {
            val result = createMeasureResultReportUseCase(
                MeasureResultReportParamUiModel(
                    drinkingStartTime = drinkingStartTime,
                    drinkingEndTime = getDateTimeNow(),
                    drinks = drinks.map { (alcoholType, glass) ->
                        DrinkUiModel(alcoholType, glass)
                    },
                    totalDrinkGlasses = state.value.totalCount,
                ).toDomainModel(),
            )
            _createReportSuccessEvent.value = Event(result.id)
        }
    }

    fun updateCurrentAlcoholId(alcoholId: Int) {
        _state.value = _state.value.copy(currentAlcoholId = alcoholId)
    }

    private fun getDrinkLimit() {
        val drinkList = drinks.map { (alcoholType, glass) ->
            DrinkUiModel(alcoholType, glass)
        }

        viewModelScope.launch {
            val drinkInfo = handleConsumeDrinkInfo(
                getAlcoholLimitUseCase(
                    AlcoholLimitParamUiModel(drinkList).toDomainModel(),
                ),
            )

            drinkInfo?.let { drinkInfoUiModel ->
                _state.update { state ->
                    state.copy(
                        level = drinkInfoUiModel.title.text,
                        isDrunken = drinkInfoUiModel.isDrunken,
                    )
                }
            }
        }
    }

    private fun handleConsumeDrinkInfo(result: Result<ConsumeDrinkInfo>): ConsumeDrinkInfoUiModel? {
        return when (result) {
            is Result.Success -> result.value.toUiModel()
            is Result.Error -> null
        }
    }

    fun updateIsLoading(isLoading: Boolean) {
        _state.value = _state.value.copy(isLoading = isLoading)
    }

    private fun initState(): MeasuringState {
        return MeasuringState(
            totalCount = 0,
            records = "아직 술을 마시지 않았어요",
            level = "귀엽네",
            currentAlcoholId = 0,
            alcoholTypes = ImmutableList(listOf("소주", "맥주", "위스키", "와인", "고량주")),
            isLoading = true,
            isDrunken = false,
        )
    }
}
