package com.mashup.alcoholfree.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme

class CommonWebViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlcoholFreeAndroidTheme {
                CommonWebView(modifier = Modifier.fillMaxSize(), "https://www.naver.com")
            }
        }
    }
}

@Composable
fun CommonWebView(
    modifier: Modifier = Modifier,
    url: String,
    headers: Map<String, String> = emptyMap(),
) {
    val webViewState = rememberWebViewState(
        url = url,
        additionalHttpHeaders = headers
    )

    WebView(
        modifier = modifier,
        state = webViewState
    )
}
