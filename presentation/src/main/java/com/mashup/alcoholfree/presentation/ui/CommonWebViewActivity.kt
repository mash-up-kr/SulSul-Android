package com.mashup.alcoholfree.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebContent
import com.google.accompanist.web.WebView
import com.google.accompanist.web.WebViewState
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme

class CommonWebViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlcoholFreeAndroidTheme {
                CommonWebView(
                    modifier = Modifier.fillMaxSize(),
                    state = WebViewState(
                        WebContent.Url(
                            url = "https://www.naver.com",
                            additionalHttpHeaders = emptyMap()
                        )
                    )
                )
            }
        }
    }
}

@Composable
fun CommonWebView(
    modifier: Modifier = Modifier,
    state: WebViewState,
) {
    WebView(
        modifier = modifier,
        state = state,
    )
}
