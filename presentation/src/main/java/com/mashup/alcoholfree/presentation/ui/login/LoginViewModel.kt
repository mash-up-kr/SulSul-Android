package com.mashup.alcoholfree.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakao.sdk.auth.model.OAuthToken
import com.mashup.alcoholfree.domain.usecase.AddTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val addTokenUseCase: AddTokenUseCase,
) : ViewModel() {

    private val _addTokenEvent = MutableLiveData<Unit>()
    val addTokenEvent: LiveData<Unit> = _addTokenEvent

    fun addKakaoToken(token: OAuthToken) {
        viewModelScope.launch {
            addTokenUseCase(token.accessToken)
            _addTokenEvent.value = Unit
        }
    }
}
