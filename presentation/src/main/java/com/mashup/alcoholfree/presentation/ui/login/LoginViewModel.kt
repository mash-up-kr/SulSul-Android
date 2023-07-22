package com.mashup.alcoholfree.presentation.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakao.sdk.auth.model.OAuthToken
import com.mashup.alcoholfree.domain.usecase.login.AddTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val addTokenUseCase: AddTokenUseCase,
) : ViewModel() {

    fun addKakaoToken(token: OAuthToken) {
        viewModelScope.launch {
            addTokenUseCase(token.accessToken)
        }
    }
}
