package com.mashup.alcoholfree.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.base.Result
import com.mashup.alcoholfree.domain.model.PromiseCard
import com.mashup.alcoholfree.domain.usecase.GetAlcoholPromiseCardsUseCase
import com.mashup.alcoholfree.domain.usecase.GetMyInfoUseCase
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholPromiseCardState
import com.mashup.alcoholfree.presentation.ui.home.model.HomeState
import com.mashup.alcoholfree.presentation.ui.home.model.TierUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.toUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.toUiState
import com.mashup.alcoholfree.presentation.utils.ImmutableList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAlcoholPromiseCardsUseCase: GetAlcoholPromiseCardsUseCase,
    private val getMyInfoUseCase: GetMyInfoUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(initHomeState())
    val state = _state.asStateFlow()

    fun getUserInfo() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(isLoading = true)
            }

            val myInfo = getMyInfoUseCase()

            _state.update { state ->
                state.copy(
                    userName = myInfo.nickname,
                    alcoholTier = myInfo.tier?.toUiModel(),
                    drinkLimit = myInfo.drinkingLimits?.toUiModel(),
                    isLoading = false,
                )
            }
            getAlcoholPromiseCards()
        }
    }

    fun getAlcoholPromiseCards() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(isLoading = true)
            }

            val cards: List<AlcoholPromiseCardState>? =
                handleAlcoholPromiseCards(getAlcoholPromiseCardsUseCase())?.map { card ->
                    card.toUiModel().toUiState()
                }

            cards?.let { cardsState ->
                _state.update { state ->
                    state.copy(
                        cardList = ImmutableList(cardsState),
                        isLoading = false,
                    )
                }
            }
        }
    }

    private fun handleAlcoholPromiseCards(result: Result<List<PromiseCard>>): List<PromiseCard>? {
        return when (result) {
            is Result.Success -> result.value
            is Result.Error -> null
        }
    }

    private fun initHomeState(): HomeState {
        // TODO("초기 상태 셋팅")
        return HomeState(
            userName = "",
            alcoholTier = TierUiModel(
                subTitle = "",
                title = "",
                tierImageUrl = "",
            ),
            cardList = ImmutableList(emptyList()),
            drinkLimit = null,
        )
    }
}
