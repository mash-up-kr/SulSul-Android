package com.mashup.alcoholfree.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.usecase.GetAlcoholPromiseCardsUseCase
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholPromiseCardState
import com.mashup.alcoholfree.presentation.ui.home.model.toUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.toUiState
import com.mashup.alcoholfree.presentation.utils.ImmutableList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAlcoholPromiseCardsUseCase: GetAlcoholPromiseCardsUseCase,
) : ViewModel() {

    private val _cardList = MutableStateFlow(ImmutableList<AlcoholPromiseCardState>(emptyList()))
    val cardList = _cardList.asStateFlow()

    fun getAlcoholPromiseCards() {
        viewModelScope.launch {
            val cards = getAlcoholPromiseCardsUseCase().map {
                it.toUiModel().toUiState()
            }
            _cardList.value = ImmutableList(cards)
        }
    }
}
