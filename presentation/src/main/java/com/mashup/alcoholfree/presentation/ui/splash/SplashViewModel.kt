package com.mashup.alcoholfree.presentation.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kakao.sdk.auth.TokenManagerProvider
import com.mashup.alcoholfree.domain.usecase.AddTokenUseCase
import com.mashup.alcoholfree.domain.usecase.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val addTokenUseCase: AddTokenUseCase,
    getTokenUseCase: GetTokenUseCase,
) : ViewModel() {

    private val preAccessToken = getTokenUseCase().asLiveData()

    private val _addTokenEvent = MutableLiveData<Unit>()
    val addTokenEvent: LiveData<Unit> = _addTokenEvent

    fun checkAccessToken(): Unit? {
        return TokenManagerProvider
            .instance
            .manager
            .getToken()
            ?.accessToken
            ?.let { accessToken ->
                if (!preAccessToken.value.equals(accessToken)) {
                    addKakaoToken(accessToken)
                }
            }
    }

    private fun addKakaoToken(accessToken: String) {
        viewModelScope.launch {
            addTokenUseCase(accessToken)
            _addTokenEvent.value = Unit
        }
    }
}
