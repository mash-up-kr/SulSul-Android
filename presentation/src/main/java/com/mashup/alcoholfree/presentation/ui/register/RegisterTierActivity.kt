package com.mashup.alcoholfree.presentation.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.mashup.alcoholfree.presentation.ui.component.SulSulWebView
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme

class RegisterTierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AlcoholFreeAndroidTheme {
                SulSulWebView(
                    modifier = Modifier
                        .fillMaxSize(),
                    url = "https://dev-onboarding.sulsul.app/measure",
                    isTransparent = false,
                    bridge = RegisterTierBridge(
                        onSuccess = { alcoholType, glasses ->
                            // TODO("주량 등록 해야합니다~!")
                            finish()
                        }),
                    state = null,
                )
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterTierActivity::class.java)
        }
    }
}