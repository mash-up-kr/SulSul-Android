package com.mashup.alcoholfree.presentation.ui.component

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.WebViewState

@Composable
fun SulSulWebView(
    modifier: Modifier = Modifier,
    state: WebViewState,
) {
    WebView(
        modifier = modifier,
        state = state,
    )
}

@SuppressLint("SetJavaScriptEnabled", "JavascriptInterface")
@Composable
fun SulSulWebView(
    modifier: Modifier = Modifier,
    state: WebViewState,
    bridge: Any,
    bridgeName: String,
) {
    WebView(
        modifier = modifier,
        state = state,
        onCreated = { webView ->
            with(webView) {
                settings.javaScriptEnabled = true
                addJavascriptInterface(bridge, bridgeName)
            }
        }
    )
}
