package com.mashup.alcoholfree.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.usecase.GetAlcoholPromiseCardsUseCase
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholTier
import com.mashup.alcoholfree.presentation.ui.home.model.HomeState
import com.mashup.alcoholfree.presentation.ui.home.model.toUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.toUiState
import com.mashup.alcoholfree.presentation.utils.ImmutableList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAlcoholPromiseCardsUseCase: GetAlcoholPromiseCardsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(initHomeState())
    val state = _state.asStateFlow()

    fun getUserInfo() {
        // TODO("내정보 API 연결해야함")
        viewModelScope.launch {
            delay(700)
            _state.update { state ->
                state.copy(
                    userName = "우진",
                    alcoholTier = AlcoholTier.LEVEL3,
                )
            }
        }
    }

    fun getAlcoholPromiseCards() {
        viewModelScope.launch {
            val cards = getAlcoholPromiseCardsUseCase().map { card ->
                card.toUiModel().toUiState()
            }
            _state.update { state ->
                state.copy(cardList = ImmutableList(cards))
            }
        }
    }

    private fun initHomeState(): HomeState {
        // TODO("초기 상태 셋팅")
        return HomeState(
            userName = "회원",
            alcoholTier = AlcoholTier.EMPTY,
            cardList = ImmutableList(emptyList()),
        )
    }
}
