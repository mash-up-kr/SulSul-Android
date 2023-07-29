package com.mashup.alcoholfree.presentation.ui.measuring

import androidx.lifecycle.ViewModel
import com.mashup.alcoholfree.presentation.ui.measuring.model.MeasuringState
import com.mashup.alcoholfree.presentation.utils.ImmutableList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MeasuringViewModel @Inject constructor(

): ViewModel() {
    private val _state = MutableStateFlow(initState())
    val state: StateFlow<MeasuringState>
        get() = _state

    fun updateCurrentAlcoholId(alcoholId: Int) {
        _state.value = _state.value.copy(currentAlcoholId = alcoholId)
    }

    private fun initState(): MeasuringState {
        return MeasuringState(
            totalCount = 25,
            records = "와인 2잔 · 소주 2잔 · 맥주 3잔",
            level = "미쳤다",
            currentAlcoholId = 0,
            alcoholTypes = ImmutableList(listOf("소주", "맥주", "위스키", "와인", "고량주")),
        )
    }
}
