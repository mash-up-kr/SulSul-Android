package com.mashup.alcoholfree.presentation.ui.component

import android.annotation.SuppressLint
import android.view.HapticFeedbackConstants
import android.view.MotionEvent
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebContent
import com.google.accompanist.web.WebView
import com.google.accompanist.web.WebViewState
import com.mashup.alcoholfree.presentation.ui.measuring.SulSulWebViewBridge
import com.mashup.alcoholfree.presentation.ui.measuring.model.SulSulWebViewState

@SuppressLint("SetJavaScriptEnabled", "JavascriptInterface")
@Composable
fun SulSulWebView(
    modifier: Modifier = Modifier,
    state: WebViewState,
) {
    WebView(
        modifier = modifier,
        state = state,
        onCreated = { webView ->
            with(webView) {
                settings.javaScriptEnabled = true
            }
        },
    )
}

@SuppressLint("SetJavaScriptEnabled", "JavascriptInterface")
@Composable
fun SulSulWebView(
    modifier: Modifier = Modifier,
    url: String,
    state: SulSulWebViewState,
    bridge: SulSulWebViewBridge,
    bridgeName: String,
    isTransparent: Boolean
) {
    WebView(
        modifier = modifier,
        state = WebViewState(WebContent.Url(url)),
        onCreated = { webView ->

            with(webView) {
                if (isTransparent) {
                    setBackgroundColor(0) // 웹뷰 투명 배경
                }
                settings.javaScriptEnabled = true
                addJavascriptInterface(bridge, bridgeName)
                onWebViewTouch(webView, bridge, state)
            }
        },
    )
}

@SuppressLint("ClickableViewAccessibility")
private fun onWebViewTouch(
    webView: WebView,
    webViewBridge: SulSulWebViewBridge,
    state: SulSulWebViewState,
) {
    webView.setOnTouchListener { view, motionEvent ->
        if (
            view.id == webView.id &&
            motionEvent.action == MotionEvent.ACTION_DOWN
        ) {
            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
            webViewBridge.onWebViewClicked(webView, state.clickMessage)
        }
        false
    }
}
