package com.mashup.alcoholfree.presentation.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.mashup.alcoholfree.presentation.ui.component.SulSulWebView
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.Black
import com.mashup.alcoholfree.presentation.utils.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterTierActivity : ComponentActivity() {
    private val viewModel by viewModels<RegisterTierViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AlcoholFreeAndroidTheme {
                Column(
                    modifier = Modifier.background(Black),
                ) {
                    SulSulWebView(
                        modifier = Modifier
                            .fillMaxSize()
                            .navigationBarsPadding(),
                        url = WEB_ONBOARDING_URL,
                        isTransparent = false,
                        bridge = RegisterTierBridge(
                            onSuccess = viewModel::registerTier
                        ),
                        state = null,
                    )
                }
            }
        }
        observeData()
    }

    private fun observeData() {
        viewModel.successEvent.observeEvent(this) {
            setResult(RESULT_OK)
            finish()
        }
    }

    companion object {
        private const val WEB_ONBOARDING_URL = "https://dev-onboarding.sulsul.app/measure"

        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterTierActivity::class.java)
        }
    }
}
