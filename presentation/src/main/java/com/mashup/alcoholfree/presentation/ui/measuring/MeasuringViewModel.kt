package com.mashup.alcoholfree.presentation.ui.measuring

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.usecase.GetTierSubTitleUseCase
import com.mashup.alcoholfree.presentation.ui.measuring.model.MeasuringState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeasuringViewModel @Inject constructor(
    private val getTierSubTitleUseCase: GetTierSubTitleUseCase,
) : ViewModel() {
    private val _state: MutableStateFlow<MeasuringState> = MutableStateFlow(initState())
    val state: StateFlow<MeasuringState> = _state.asStateFlow()

    private val _tierSubTitles = MutableLiveData<List<String>>()
    val tierSubTitles: LiveData<List<String>>
        get() = _tierSubTitles

    fun loadTierSubtitles() {
        viewModelScope.launch {
            _tierSubTitles.value = getTierSubTitleUseCase()
        }
    }

    fun onAlcoholSelectionChanged(alcoholId: Int) {
        _state.value = _state.value.copy(currentAlcoholId = alcoholId)
    }

    fun updateTierBadgeTitle(title: String) {
        _state.value = _state.value.copy(level = title)
    }

    private fun initState(): MeasuringState {
        /* TODO: 초기값 재설정 필요 */
        return MeasuringState(
            totalCount = 0,
            records = "와인 2잔 · 소주 2잔 · 맥주 3잔",
            level = "미쳤다",
            currentAlcoholId = 0,
            alcoholTypes = listOf("소주", "맥주", "위스키", "와인", "고량주"),
        )
    }
}
