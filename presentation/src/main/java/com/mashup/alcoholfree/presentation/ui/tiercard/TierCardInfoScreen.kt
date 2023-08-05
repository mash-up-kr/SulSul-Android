package com.mashup.alcoholfree.presentation.ui.tiercard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.ui.component.SulSulBackButton
import com.mashup.alcoholfree.presentation.ui.component.SulSulLoading
import com.mashup.alcoholfree.presentation.ui.component.SulSulWebView
import com.mashup.alcoholfree.presentation.ui.theme.Black
import com.mashup.alcoholfree.presentation.ui.tiercard.model.TierCardInfoState

private val WEB_VIEW_ONBOARDING_RESULT_URL = "dev-onboarding.sulsul.app/result"

@Composable
fun TierCardInfoScreen(
    state: TierCardInfoState,
    onIsWebViewLoading: (Boolean) -> Unit,
    onFinishClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
    ) {
        SulSulWebView(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            url = getTierCardInfoUrl(state.drinkLimit.alcoholType, state.drinkLimit.glasses),
            isTransparent = false,
            onIsWebViewLoading = onIsWebViewLoading,
        )

        SulSulBackButton(
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 8.dp, start = 16.dp)
                .align(Alignment.TopStart),
            onClick = onFinishClick,
        )

        if (state.isLoading) {
            SulSulLoading()
        }
    }
}

private fun getTierCardInfoUrl(
    drinkType: String,
    glass: Int,
): String {
    return "$WEB_VIEW_ONBOARDING_RESULT_URL/?drinkType=$drinkType&glasses=$glass"
}
