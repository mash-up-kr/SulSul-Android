package com.mashup.alcoholfree.presentation.ui.tiercard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mashup.alcoholfree.presentation.ui.home.model.DrinkUiModel
import com.mashup.alcoholfree.presentation.ui.tiercard.model.TierCardInfoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TierCardInfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(initData())
    val state: StateFlow<TierCardInfoState>
        get() = _state

    private val drinkType = savedStateHandle.get<String>("drinkType") ?: ""
    private val glass = savedStateHandle.get<Int>("glass") ?: 0

    init {
        _state.update { state ->
            state.copy(
                drinkLimit = DrinkUiModel(
                    alcoholType = drinkType,
                    glasses = glass,
                ),
            )
        }
    }

    fun updateLoading(isLoading: Boolean) {
        _state.value = _state.value.copy(isLoading = isLoading)
    }

    private fun initData(): TierCardInfoState {
        return TierCardInfoState(
            isLoading = true,
            drinkLimit = DrinkUiModel("", 0),
        )
    }
}
