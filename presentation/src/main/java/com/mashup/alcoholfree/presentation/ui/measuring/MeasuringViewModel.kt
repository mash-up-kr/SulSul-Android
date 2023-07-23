package com.mashup.alcoholfree.presentation.ui.measuring

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.usecase.GetTierSubTitleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeasuringViewModel @Inject constructor(
    private val getTierSubTitleUseCase: GetTierSubTitleUseCase,
): ViewModel() {
    private val tierSubTitles = mutableListOf<String>()

    fun loadTierSubtitles() {
        viewModelScope.launch {
            tierSubTitles.clear()
            tierSubTitles.addAll(getTierSubTitleUseCase())
        }
    }
}
