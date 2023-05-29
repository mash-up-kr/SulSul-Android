package com.mashup.alcoholfree.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.mashup.alcoholfree.domain.usecase.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getTokenUseCase: GetTokenUseCase,
) : ViewModel() {

    val accessToken: Flow<String> = getTokenUseCase()
}
