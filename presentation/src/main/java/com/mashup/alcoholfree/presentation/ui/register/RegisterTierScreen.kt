package com.mashup.alcoholfree.presentation.ui.register

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.ui.component.InvalidCountDialog
import com.mashup.alcoholfree.presentation.ui.component.SulSulBackButton
import com.mashup.alcoholfree.presentation.ui.component.SulSulLoading
import com.mashup.alcoholfree.presentation.ui.component.SulSulWebView
import com.mashup.alcoholfree.presentation.ui.measuring.AlcoholBackPressDialog
import com.mashup.alcoholfree.presentation.ui.register.model.RegisterTierState
import com.mashup.alcoholfree.presentation.ui.theme.Black

private const val WEB_ONBOARDING_URL = "https://onboarding.sulsul.app/measure"

@Composable
fun RegisterTierScreen(
    state: RegisterTierState,
    onValidationDialogVisibilityChanged: (Boolean) -> Unit,
    onSuccess: (String, Int) -> Unit,
    onIsWebViewLoading: (Boolean) -> Unit,
    onFinishClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
    ) {
        var isDialogVisible by remember { mutableStateOf(false) }

        SulSulWebView(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            url = WEB_ONBOARDING_URL,
            isTransparent = false,
            bridge = RegisterTierBridge(
                onSuccess = onSuccess,
            ),
            state = null,
            onIsWebViewLoading = onIsWebViewLoading,
        )

        BackHandler(enabled = true) {
            isDialogVisible = true
        }

        SulSulBackButton(
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 8.dp, start = 16.dp)
                .align(Alignment.TopStart),
            onClick = { isDialogVisible = true },
        )

        if (isDialogVisible) {
            AlcoholBackPressDialog(
                onContinueClick = { isDialogVisible = false },
                onExitClick = onFinishClick,
            )
        }
    }

    if (state.isLoading) {
        SulSulLoading()
    }

    if (state.isValidationDialogVisible) {
        InvalidCountDialog(
            onContinueClick = { onValidationDialogVisibilityChanged(false) },
        )
    }
}
