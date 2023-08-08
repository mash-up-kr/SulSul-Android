package com.mashup.alcoholfree.presentation.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.usecase.GetAlcoholPromiseCardsUseCase
import com.mashup.alcoholfree.domain.usecase.GetMyInfoUseCase
import com.mashup.alcoholfree.presentation.ui.home.model.HomeState
import com.mashup.alcoholfree.presentation.ui.home.model.toUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.toUiState
import com.mashup.alcoholfree.presentation.utils.ImmutableList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAlcoholPromiseCardsUseCase: GetAlcoholPromiseCardsUseCase,
    private val getMyInfoUseCase: GetMyInfoUseCase,
) : ViewModel() {
    val state: StateFlow<HomeState> = makeCombinedState().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = initHomeState()
    )

    private fun makeCombinedState(): Flow<HomeState> = combine(
        getMyInfoUseCase(),
        getAlcoholPromiseCardsUseCase(),
    ) { userInfo, promiseCards ->
        val cards = promiseCards.map { card ->
            card.toUiModel().toUiState()
        }

        HomeState(
            userName = userInfo.nickname,
            alcoholTier = userInfo.tier?.toUiModel(),
            drinkLimit = userInfo.drinkingLimits?.toUiModel(),
            cardList = ImmutableList(cards),
            isLoading = false,
        )
    }.catch {
        Log.d("HomeViewModel", it.toString())
    }

    private fun initHomeState(): HomeState {
        return HomeState(
            userName = "",
            alcoholTier = null,
            cardList = ImmutableList(emptyList()),
            drinkLimit = null,
            isLoading = true,
        )
    }
}
