package com.mashup.alcoholfree.presentation.ui.register

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mashup.alcoholfree.presentation.ui.component.SulSulLoading
import com.mashup.alcoholfree.presentation.ui.component.SulSulWebView
import com.mashup.alcoholfree.presentation.ui.register.model.RegisterTierState

@Composable
fun RegisterTierScreen(
    state: RegisterTierState,
    onSuccess: (String, Int) -> Unit,
    onIsWebViewLoading: (Boolean) -> Unit,
) {
    SulSulWebView(
        modifier = Modifier
            .fillMaxSize(),
        url = "https://dev-onboarding.sulsul.app/measure",
        isTransparent = false,
        bridge = RegisterTierBridge(
            onSuccess = onSuccess,
        ),
        state = null,
        onIsWebViewLoading = onIsWebViewLoading,
    )

    if (state.isLoading) {
        SulSulLoading()
    }
}
