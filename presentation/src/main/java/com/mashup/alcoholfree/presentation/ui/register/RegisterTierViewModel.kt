package com.mashup.alcoholfree.presentation.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashup.alcoholfree.domain.model.RegisterTierParam
import com.mashup.alcoholfree.domain.usecase.RegisterDrinkingLimitUseCase
import com.mashup.alcoholfree.presentation.ui.register.model.RegisterTierState
import com.mashup.alcoholfree.presentation.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterTierViewModel @Inject constructor(
    private val registerDrinkingLimitUseCase: RegisterDrinkingLimitUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(RegisterTierState(isLoading = true))
    val state: StateFlow<RegisterTierState>
        get() = _state

    private val _successEvent = MutableLiveData<Event<String>>()
    val successEvent: LiveData<Event<String>> get() = _successEvent

    fun registerTier(drinkType: String, glass: Int) {
        viewModelScope.launch {
            val result = registerDrinkingLimitUseCase(
                RegisterTierParam(
                    drinkType = drinkType,
                    glass = glass,
                ),
            )
            _successEvent.value = Event(result)
        }
    }

    fun updateLoading(isLoading: Boolean) {
        _state.value = _state.value.copy(isLoading = isLoading)
    }
}
