package com.mashup.alcoholfree.presentation.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.google.accompanist.web.WebContent
import com.google.accompanist.web.WebViewState
import com.mashup.alcoholfree.presentation.ui.component.SulSulWebView

class RegisterTierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            SulSulWebView(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding(),
                state = WebViewState(
                    WebContent.Url(
                        url = "https://dev-onboar뷰ding.sulsul.app/measure"
                    )
                ),
                isTransparent = false,
                bridge = RegisterTierBridge(context = this),
                bridgeName = "sulsulBridge"
            )
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterTierActivity::class.java)
        }
    }
}
