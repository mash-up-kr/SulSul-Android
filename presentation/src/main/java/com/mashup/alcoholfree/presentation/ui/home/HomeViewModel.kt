package com.mashup.alcoholfree.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.usecase.GetAlcoholPromiseCardsUseCase
import com.mashup.alcoholfree.domain.usecase.GetMyInfoUseCase
import com.mashup.alcoholfree.presentation.ui.home.model.HomeState
import com.mashup.alcoholfree.presentation.ui.home.model.toUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.toUiState
import com.mashup.alcoholfree.presentation.utils.ImmutableList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getAlcoholPromiseCardsUseCase: GetAlcoholPromiseCardsUseCase,
    getMyInfoUseCase: GetMyInfoUseCase,
) : ViewModel() {
    val state = combine(
        getMyInfoUseCase(),
        getAlcoholPromiseCardsUseCase(),
    ) { userInfo, promiseCards ->
        val cards = promiseCards.map { card ->
            card.toUiModel().toUiState()
        }

        HomeState(
            userName = userInfo.nickname,
            alcoholTier = userInfo.tier?.toUiModel(),
            cardList = ImmutableList(cards)
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = initHomeState()
    )

    private fun initHomeState(): HomeState {
        return HomeState(
            userName = "",
            alcoholTier = null,
            cardList = ImmutableList(emptyList()),
        )
    }
}
